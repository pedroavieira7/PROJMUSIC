package main.java.br.com.tech4me.music;

import com.musicas.service.MusicaService;
import com.musicas.shared.MusicaDto;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/musicas")
public class MusicaController {
    private final MusicaService musicaService;

    public MusicaController(MusicaService musicaService) {
        this.musicaService = musicaService;
    }

    @GetMapping
    public List<MusicaDto> listarMusicas() {
        return musicaService.listarMusicas();
    }

    @GetMapping("/{id}")
    public MusicaDto buscarMusicaPorId(@PathVariable String id) {
        return musicaService.buscarMusicaPorId(id);
    }

    @PostMapping
    public MusicaDto criarMusica(@RequestBody MusicaDto musicaDto) {
        return musicaService.criarMusica(musicaDto);
    }

    @PutMapping("/{id}")
    public MusicaDto atualizarMusica(@PathVariable String id, @RequestBody MusicaDto musicaDto) {
        return musicaService.atualizarMusica(id, musicaDto);
    }

    @DeleteMapping("/{id}")
    public void removerMusica(@PathVariable String id) {
        musicaService.removerMusica(id);
    }
}
