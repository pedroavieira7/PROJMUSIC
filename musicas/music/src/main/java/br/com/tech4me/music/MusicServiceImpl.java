package com.musicas.service;

import com.musicas.model.Musica;
import com.musicas.repository.MusicaRepository;
import com.musicas.shared.MusicaDto;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;


@Service
public class MusicaServiceImpl implements MusicaService {
    private final MusicaRepository musicaRepository;

    public MusicaServiceImpl(MusicaRepository musicaRepository) {
        this.musicaRepository = musicaRepository;
    }

    @Override
    public List<MusicaDto> listarMusicas() {
        List<Musica> musicas = musicaRepository.findAll();
        return musicas.stream()
                .map(this::convertToDto)
                .collect(Collectors.toList());
    }

    @Override
    public MusicaDto buscarMusicaPorId(String id) {
        Optional<Musica> optionalMusica = musicaRepository.findById(id);
        return optionalMusica.map(this::convertToDto).orElse(null);
    }

    @Override
    public MusicaDto criarMusica(MusicaDto musicaDto) {
        Musica novaMusica = convertToEntity(musicaDto);
        Musica musicaSalva = musicaRepository.save(novaMusica);
        return convertToDto(musicaSalva);
    }

    @Override
    public MusicaDto atualizarMusica(String id, MusicaDto musicaDto) {
        Optional<Musica> optionalMusica = musicaRepository.findById(id);
        if (optionalMusica.isPresent()) {
            Musica musicaExistente = optionalMusica.get();
            musicaExistente.setTitulo(musicaDto.getTitulo());
            
            Musica musicaAtualizada = musicaRepository.save(musicaExistente);
            return convertToDto(musicaAtualizada);
        }
        return null;
    }

    @Override
    public void removerMusica(String id) {
        musicaRepository.deleteById(id);
    }

    
    private MusicaDto convertToDto(Musica musica) {
        // Implemente a conversão aqui
    }

    private Musica convertToEntity(MusicaDto musicaDto) {
        // Implemente a conversão aqui
    }
}
