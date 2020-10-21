package csvutility;

import java.io.Reader;
import java.util.*;

public interface ICSVBuilder<E> {

	Iterable<E> getCSVFileIterable(Reader reader, Class<E> csvClass) throws CustomException;
	
	 List<E> getCSVList(Reader reader, Class<E> csvClass) throws CustomException;
}