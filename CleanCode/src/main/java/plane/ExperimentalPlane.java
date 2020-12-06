package plane;

import type.ExperimentalPlaneClassificationLevel;
import type.ExperimentalPlaneType;

import java.util.Objects;

public class ExperimentalPlane extends Plane{

    private ExperimentalPlaneType type;
    private ExperimentalPlaneClassificationLevel classificationLevel;

    public ExperimentalPlane(String model, int maxSpeed, int maxFlightDistance, int maxLoadCapacity, ExperimentalPlaneType type, ExperimentalPlaneClassificationLevel classificationLevel) {
        super(model, maxSpeed, maxFlightDistance, maxLoadCapacity);
        this.type = type;
        this.classificationLevel = classificationLevel;
    }

    public ExperimentalPlaneClassificationLevel getClassificationLevel(){
        return classificationLevel;
    }

    public void setClassificationLevel(ExperimentalPlaneClassificationLevel classificationLevel){
        this.classificationLevel = classificationLevel;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        if (!super.equals(o)) return false;
        ExperimentalPlane that = (ExperimentalPlane) o;
        return type == that.type &&
                classificationLevel == that.classificationLevel;
    }

    @Override
    public int hashCode() {
        return Objects.hash(super.hashCode(), type, classificationLevel);
    }

    @Override
    public String toString() {
        return super.toString().replace("}",
                ", type='" + type +
                        ", classification=" + classificationLevel +
                        '}');
    }
}
