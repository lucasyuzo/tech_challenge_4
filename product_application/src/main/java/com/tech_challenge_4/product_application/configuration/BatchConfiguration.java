package com.tech_challenge_4.product_application.configuration;

import com.tech_challenge_4.product_application.entity.Product;
import org.springframework.batch.core.Job;
import org.springframework.batch.core.Step;
import org.springframework.batch.core.job.builder.JobBuilder;
import org.springframework.batch.core.launch.support.RunIdIncrementer;
import org.springframework.batch.core.repository.JobRepository;
import org.springframework.batch.core.step.builder.StepBuilder;
import org.springframework.batch.item.ItemReader;
import org.springframework.batch.item.ItemWriter;
import org.springframework.batch.item.database.BeanPropertyItemSqlParameterSourceProvider;
import org.springframework.batch.item.database.builder.JdbcBatchItemWriterBuilder;
import org.springframework.batch.item.file.builder.FlatFileItemReaderBuilder;
import org.springframework.batch.item.file.mapping.BeanWrapperFieldSetMapper;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.io.ClassPathResource;
import org.springframework.transaction.PlatformTransactionManager;

import javax.sql.DataSource;

@Configuration
public class BatchConfiguration {

    @Bean
    public Job processProduct(JobRepository jobRepository, Step processFile) {
        return new JobBuilder("processProduct", jobRepository)
                .incrementer(new RunIdIncrementer())
                .start(processFile)
                .build();
    }

    @Bean
    public Step processFile(
            JobRepository jobRepository,
            PlatformTransactionManager transactionManager,
            ItemReader<Product> itemReader,
            ItemWriter<Product> itemWriter
    ) {
        return new StepBuilder("processFile", jobRepository)
                .<Product, Product>chunk(20, transactionManager)
                .reader(itemReader)
                .writer(itemWriter)
                .build();
    }

    @Bean
    public ItemReader<Product> itemReader() {
        BeanWrapperFieldSetMapper<Product> fieldSetMapper = new BeanWrapperFieldSetMapper<>();
        fieldSetMapper.setTargetType(Product.class);
        return new FlatFileItemReaderBuilder<Product>()
                .name("productItemReader")
                .resource(new ClassPathResource("products.csv"))
                .delimited()
                .names("id", "name", "description", "price", "quantity")
                .fieldSetMapper(fieldSetMapper)
                .build();
    }

    @Bean
    public ItemWriter<Product> itemWriter(DataSource dataSource) {
        return new JdbcBatchItemWriterBuilder<Product>()
                .itemSqlParameterSourceProvider(new BeanPropertyItemSqlParameterSourceProvider<>())
                .dataSource(dataSource)
                .sql(
                        "INSERT INTO product " +
                        "(id, name, description, price, quantity)" +
                        "VALUES (:id, :name, :description, :price, :quantity)"
                )
                .build();
    }

}
