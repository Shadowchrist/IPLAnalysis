package csvutility;

import java.io.*;
import java.util.*;
import com.opencsv.bean.CsvToBean;
import com.opencsv.bean.CsvToBeanBuilder;

public class CSVIteratorBuilder<E> implements ICSVBuilder<E> {

	@Override
	public Iterable<E> getCSVFileIterable(Reader reader, Class<E> csvClass) throws CustomException {
        try {
            CsvToBean<E> csvToBean = new CsvToBeanBuilder<E>(reader).withSeparator(',').withIgnoreQuotations(true).withIgnoreLeadingWhiteSpace(true).withType(csvClass).build();
            Iterator<E> iterator = csvToBean.iterator();
            Iterable<E> csvIterable = () -> iterator;
            return csvIterable;
        } catch (RuntimeException e) {
            throw new CustomException(CustomException.ExceptionType.PARSING_ERROR, e.getMessage());
        }
    }

    @Override
    public List<E> getCSVList(Reader reader,Class<E> csvClass) throws CustomException {
        try {
            CsvToBean<E> csvToBean = new CsvToBeanBuilder<E>(reader).withSeparator(',').withIgnoreQuotations(true).withIgnoreLeadingWhiteSpace(true).withType(csvClass).build();
            return csvToBean.parse();
        } catch (RuntimeException e) {
        	throw new CustomException(CustomException.ExceptionType.PARSING_ERROR, e.getMessage());
        }
    }

}
