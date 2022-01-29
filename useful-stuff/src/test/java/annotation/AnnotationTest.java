package annotation;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.lang.annotation.Annotation;
import java.lang.reflect.Field;

public class AnnotationTest {

    @Test
    public void testAnnotationFetch() {
        Assertions.assertEquals("annotationVictim", AnnotationVictimModel.class
                .getAnnotation(SampleClassAnnotation.class).appName());
        for (Field field : AnnotationVictimModel.class.getDeclaredFields()) {
            Annotation annotation = field.getAnnotation(SampleFieldAnnotation.class);
            if (annotation != null) {
                Assertions.assertEquals("id", field
                        .getAnnotation(SampleFieldAnnotation.class).columnName());
            }
        }
    }
}
