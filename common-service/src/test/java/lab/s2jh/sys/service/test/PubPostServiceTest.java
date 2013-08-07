package lab.s2jh.sys.service.test;

import java.util.List;

import lab.s2jh.core.test.SpringTransactionalTestCase;
import lab.s2jh.core.test.TestObjectUtils;
import lab.s2jh.sys.entity.PubPost;
import lab.s2jh.sys.service.PubPostService;

import org.junit.Assert;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;

import com.google.common.collect.Sets;

@ContextConfiguration(locations = { "classpath:/context/spring*.xml" })
public class PubPostServiceTest extends SpringTransactionalTestCase {

	@Autowired
	private PubPostService pubPostService;

    @Test
    public void findByPage() {
        //Insert mock entity
        PubPost entity = TestObjectUtils.buildMockObject(PubPost.class);
        pubPostService.save(entity);
        Assert.assertTrue(entity.getId() != null);

        //JPA/Hibernate query validation
        List<PubPost> items = pubPostService.findAll(Sets.newHashSet(entity.getId()));
        Assert.assertTrue(items.size() >= 1);
    }
    
    @Test
    public void findPublished() {
        //Insert mock entity
        PubPost entity = TestObjectUtils.buildMockObject(PubPost.class);
        pubPostService.save(entity);
        Assert.assertTrue(entity.getId() != null);

    
        pubPostService.findPublished();
    }
}