package dev.morphia;

import dev.morphia.annotations.Entity;
import dev.morphia.annotations.Id;
import org.bson.types.ObjectId;
import org.junit.Test;

import static dev.morphia.query.experimental.filters.Filters.eq;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;

public class TestInheritance extends TestBase {
    @Test
    public void testSavingAndLoadingAClassWithDeepInheritance() {
        // given
        final Child jimmy = new Child();
        jimmy.setName("jimmy");
        getDs().save(jimmy);

        // when
        final Child loaded = getDs().find(Child.class).filter(eq("_id", jimmy.getId())).first();

        // then
        assertNotNull(loaded);
        assertEquals(jimmy.getName(), loaded.getName());
    }

    @Entity
    public static class Child extends Father {
    }

    @Entity
    public static class Father extends GrandFather {
    }

    @Entity
    public static class GrandFather {
        @Id
        private ObjectId id;
        private String name;

        public ObjectId getId() {
            return id;
        }

        public void setId(ObjectId id) {
            this.id = id;
        }

        public String getName() {
            return name;
        }

        public void setName(String name) {
            this.name = name;
        }
    }
}
