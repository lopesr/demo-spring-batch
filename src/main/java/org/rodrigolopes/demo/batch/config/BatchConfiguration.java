package org.rodrigolopes.demo.batch.config;

import java.util.ArrayList;
import java.util.List;

import org.rodrigolopes.demo.batch.file.reader.CompositeRegistroLineTokenizer;
import org.rodrigolopes.demo.batch.file.reader.RegistroFieldSetMapper;
import org.rodrigolopes.demo.batch.file.register.IRegistro;
import org.rodrigolopes.demo.batch.file.writer.RegistroWriter;
import org.springframework.batch.core.Job;
import org.springframework.batch.core.Step;
import org.springframework.batch.core.configuration.annotation.EnableBatchProcessing;
import org.springframework.batch.core.configuration.annotation.JobBuilderFactory;
import org.springframework.batch.core.configuration.annotation.StepBuilderFactory;
import org.springframework.batch.core.launch.support.RunIdIncrementer;
import org.springframework.batch.item.file.FlatFileItemReader;
import org.springframework.batch.item.file.builder.FlatFileItemReaderBuilder;
import org.springframework.batch.item.file.mapping.DefaultLineMapper;
import org.springframework.batch.item.file.transform.FixedLengthTokenizer;
import org.springframework.batch.item.file.transform.Range;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.io.ClassPathResource;

@Configuration
@EnableBatchProcessing
public class BatchConfiguration {

	@Autowired
	public JobBuilderFactory jobBuilderFactory;
	
	@Autowired
	public StepBuilderFactory stepBuilderFactory;
	
	@Bean
	public FlatFileItemReader<IRegistro> reader() {
		return new FlatFileItemReaderBuilder<IRegistro>()
					.resource(new ClassPathResource("fileSingleRecord.rem"))
					.lineMapper(lineMapper())
					.saveState(false)
					.build();
	}
	
	@Bean
	public DefaultLineMapper<IRegistro> lineMapper() {
		DefaultLineMapper<IRegistro> lineMapper = new DefaultLineMapper<>();
		lineMapper.setFieldSetMapper(fieldSetMapper());
		lineMapper.setLineTokenizer(tokenizer());
		return lineMapper;
	}
	
	@Bean
	public RegistroFieldSetMapper fieldSetMapper() {
		return new RegistroFieldSetMapper();
	}
	
	@Bean
	public CompositeRegistroLineTokenizer tokenizer() {
		CompositeRegistroLineTokenizer tokenizer = new CompositeRegistroLineTokenizer();
		tokenizer.setHeaderTokenizer(headerTokenizer());
		tokenizer.setRegisterTokenizer(registerTokenizer());
		tokenizer.setFooterTokenizer(trailerTokenizer());
		return tokenizer;
		
	}
	
	@Bean
	public FixedLengthTokenizer headerTokenizer() {
		FixedLengthTokenizer headerTokenizer = new FixedLengthTokenizer();
		
		List<Range> ranges = new ArrayList<Range>();
		ranges.add(new Range(1,1));
		ranges.add(new Range(2,23));
		ranges.add(new Range(24,44));
		ranges.add(new Range(45,50));
		
		Range[] rangeArray = new Range[ranges.size()];
		ranges.toArray(rangeArray);
		
		headerTokenizer.setColumns(rangeArray);
		
		return headerTokenizer;
	}
	
	@Bean
	public FixedLengthTokenizer registerTokenizer() {
		FixedLengthTokenizer headerTokenizer = new FixedLengthTokenizer();
		
		List<Range> ranges = new ArrayList<Range>();
		ranges.add(new Range(1,1));
		ranges.add(new Range(2,8));
		ranges.add(new Range(9,23));
		ranges.add(new Range(45,50));
		
		Range[] rangeArray = new Range[ranges.size()];
		ranges.toArray(rangeArray);
		
		headerTokenizer.setColumns(rangeArray);
		
		return headerTokenizer;
	}
	
	@Bean
	public FixedLengthTokenizer trailerTokenizer() {
		FixedLengthTokenizer headerTokenizer = new FixedLengthTokenizer();
		
		List<Range> ranges = new ArrayList<Range>();
		ranges.add(new Range(1,1));
		ranges.add(new Range(2,8));
		ranges.add(new Range(9,23));
		ranges.add(new Range(45,50));
		
		Range[] rangeArray = new Range[ranges.size()];
		ranges.toArray(rangeArray);
		
		headerTokenizer.setColumns(rangeArray);

		return headerTokenizer;
	}
	
	@Bean
	public Job processaArquivoJob(Step step1) {
		return jobBuilderFactory.get("processaArquivoJob")
				.incrementer(new RunIdIncrementer())
				.flow(step1)
				.end()
				.build();
	}

	@Bean
	public Step step1(RegistroWriter writer) {
		return stepBuilderFactory.get("step1")
				.<IRegistro, IRegistro> chunk(10)
	            .reader(reader())
	            .writer(writer)
	            .build();
	}
	
	@Bean
	public RegistroWriter writer(){
		return new RegistroWriter();
	}
	
}
