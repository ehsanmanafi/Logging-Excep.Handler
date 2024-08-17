package corp.spgc.mineralwater.exception.definition;

public class EntityDeletingException extends RuntimeException {
    public EntityDeletingException(String error_in_deleting) {
        super(error_in_deleting);
    }
}
