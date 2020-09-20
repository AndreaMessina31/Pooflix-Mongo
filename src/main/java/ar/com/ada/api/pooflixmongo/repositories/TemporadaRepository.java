package ar.com.ada.api.pooflixmongo.repositories;
import org.bson.types.ObjectId;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;
import ar.com.ada.api.pooflixmongo.entities.Temporada;

@Repository
public interface TemporadaRepository extends MongoRepository<Temporada, ObjectId> {
    
    Temporada findBy_id(ObjectId _id);
}
