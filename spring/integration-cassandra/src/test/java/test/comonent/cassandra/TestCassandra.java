package test.comonent.cassandra;

import com.datastax.driver.core.querybuilder.QueryBuilder;
import com.datastax.driver.core.querybuilder.Select;
import com.payjoy.integration.cassandra.tables.Person;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.data.cassandra.core.CassandraTemplate;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import javax.annotation.Resource;
import java.util.List;
import java.util.UUID;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration("classpath:spring/spring-*.xml")
public class TestCassandra {
    private static final Logger logger = LoggerFactory.getLogger(TestCassandra.class);

    @Resource
    CassandraTemplate cassandraTemplate;

    @Test
//    @Ignore
    public void testCassandraTemplateInsert() {
//        RandomModule random = new RandomModuleImpl();
//        for (int i = 0; i < 100; ++i) {
//            String name = random.getRStr(RandomModule.myint_all, 6);
//            int age = random.getRandomInt(100);
//            String address = random.getRStr(RandomModule.myint_AZ, 10);
//            Person person = new Person(name, age, address);
//            cassandraTemplate.insert(person);
//        }
    }

    public void testCassandraTemplateCounter() {

    }

    @Test
//    @Ignore
    public void testCassandraTemplateCount() {
        long size = cassandraTemplate.count("person");
        logger.debug(String.format("The person table size is [%s] ", size));
    }

    @Test
//    @Ignore`
    public void testCassandraTemplateSelectByLimt() {

        Select select = QueryBuilder.select().from("person");
        select.limit(100);
        List<Person> list = cassandraTemplate.select(select, Person.class);
        for (int i = 0; i < list.size(); ++i) {
            Person person = list.get(i);
            logger.debug(String.format("The persionid is [%s] and it's name is [%s]", person.getId(), person.getName()));
        }

    }

    @Test
//    @Ignore
    public void testCassandraTemplateSelectOne() {
        Select select = QueryBuilder.select().from("person");
        UUID uuid = UUID.fromString("634f884e-2be7-4726-aa4a-fae2db6b9a3d");
        select.where(QueryBuilder.eq("id", uuid));
        Person person = cassandraTemplate.selectOne(select, Person.class);
        logger.debug(String.format("The persionid is [%s] and name is [%s]", person.getId(), person.getName()));
    }
}
