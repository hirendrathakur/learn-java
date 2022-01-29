package annotation;

@SampleClassAnnotation(appName = "annotationVictim")
public class AnnotationVictimModel {

    @SampleFieldAnnotation(columnName = "id")
    private String sampleFieldWithAnnotation;

    private String sampleDummyField;
}
