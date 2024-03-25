package modelgen;

import lt.viko.eif.nychyporuk.client.modelgen.BaseEntity;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

class BaseEntityTest {

    private static class TestEntity extends BaseEntity {
        public TestEntity() {
            super();
        }

        public TestEntity(int id) {
            super(id);
        }
    }

    private TestEntity testEntity;

    @BeforeEach
    void setUp() {
        testEntity = new TestEntity();
    }

    @Test
    void testGetAndSetId() {
        int expectedId = 21;
        testEntity.setId(expectedId);
        assertEquals(expectedId, testEntity.getId(), "The ID should match the value set by setId");
    }

    @Test
    void testConstructorWithId() {
        int expectedId = 21;
        TestEntity entityWithId = new TestEntity(expectedId);
        assertEquals(expectedId, entityWithId.getId(), "The ID should match the value passed to the constructor");
    }
}
