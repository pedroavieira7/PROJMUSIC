package com.musicas.repository;

import org.springframework.data.mongodb.repository.MongoRepository;
import com.musicas.model.Musica;

public interface MusicaRepository extends MongoRepository<Musica, String> {
   
}
