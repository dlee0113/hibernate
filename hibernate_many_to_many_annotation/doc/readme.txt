To install your Oracle jdbc driver, issue following command:

mvn install:install-file -Dfile={Path/to/your/ojdbc.jar} -DgroupId=com.oracle -DartifactId=ojdbc6 -Dversion=11.2.0 -Dpackaging=jar

http://www.mkyong.com/maven/how-to-add-oracle-jdbc-driver-in-your-maven-local-repository/


join many to many tables

select * 
from stock left outer join (stock_category join category on stock_category.category_id = category.category_id)
using (stock_id)

http://stackoverflow.com/questions/372399/how-do-you-do-many-to-many-table-outer-joins
