package corp.spgc.mineralwater.exception.definition;

public class EntityNotFoundException extends RuntimeException {
    public EntityNotFoundException(String data_not_found) {
        super(data_not_found);
    }
}
