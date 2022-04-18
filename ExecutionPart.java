package JDBCJavaDBConnection;

import java.util.*;

 public class ExecutionPart extends ImplementationPart {

	public static void main(String[] args) {
		ExecutionPart execute = new ExecutionPart();

		execute.getLoginInfo();
		execute.getCheckupType();
		execute.getCovidCheckup();
		execute.getNormalCheckup();
		execute.getVacination();
		
		
	}

}