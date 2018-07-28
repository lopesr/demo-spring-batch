package org.rodrigolopes.demo.batch.file.reader;

import org.springframework.batch.core.listener.StepExecutionListenerSupport;
import org.springframework.batch.item.file.transform.DefaultFieldSet;
import org.springframework.batch.item.file.transform.FieldSet;
import org.springframework.batch.item.file.transform.FixedLengthTokenizer;
import org.springframework.batch.item.file.transform.LineTokenizer;

public class CompositeRegistroLineTokenizer extends StepExecutionListenerSupport implements LineTokenizer {

	private FixedLengthTokenizer headerTokenizer;
	private FixedLengthTokenizer registerTokenizer;
	private FixedLengthTokenizer footerTokenizer;
//	private StepExecution stepExecution;
	
	public void setHeaderTokenizer(FixedLengthTokenizer headerTokenizer) {
		this.headerTokenizer = headerTokenizer;
	}

	public void setRegisterTokenizer(FixedLengthTokenizer registerTokenizer) {
		this.registerTokenizer = registerTokenizer;
	}

	public void setFooterTokenizer(FixedLengthTokenizer footerTokenizer) {
		this.footerTokenizer = footerTokenizer;
	}

	@Override
	public FieldSet tokenize(String line) {


		if(line.charAt(0) == '0'){
			return headerTokenizer.tokenize(line);
		}
		else if(line.charAt(0) == '1'){
			return registerTokenizer.tokenize(line);
		}
		else if(line.charAt(0) == '9'){
//			FieldSet fs = footerTokenizer.tokenize(line);
//			long registerTotal = stepExecution.getReadCount();
//			long fileFooterTotal = fs.readLong(1);
//			if(registerTotal != fileFooterTotal){
//				throw new IllegalStateException("The total number of registers in the file footer does not match the " +
//						"number entered  File footer total: [" + fileFooterTotal + "] Total encountered during processing: [" +
//						registerTotal + "]");
//			}
//			else{
				return footerTokenizer.tokenize(line);
//			}
		}
		else{
			String[] tokens = {line};
			return new DefaultFieldSet(tokens);
		}
		
	}
	
//	@Override
//	public void beforeStep(StepExecution stepExecution) {
//		this.stepExecution = stepExecution;
//	}

}
