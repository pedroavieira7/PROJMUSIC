package com.musicas.service;

import com.musicas.shared.MusicaDto;

import java.util.List;

public interface MusicaService {
    List<MusicaDto> listarMusicas();
    MusicaDto buscarMusicaPorId(String id);
    MusicaDto criarMusica(MusicaDto musicaDto);
    MusicaDto atualizarMusica(String id, MusicaDto musicaDto);
    void removerMusica(String id);
}
