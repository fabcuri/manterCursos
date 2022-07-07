package br.com.treinamento.manterCursos.controll;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import org.springframework.web.bind.annotation.RestController;

import br.com.treinamento.manterCursos.entities.Categoria;
import br.com.treinamento.manterCursos.entities.Curso;
import br.com.treinamento.manterCursos.repository.ICursoRepository;
import br.com.treinamento.manterCursos.request.CursoPostRequest;
import br.com.treinamento.manterCursos.request.CursoPutRequest;
import br.com.treinamento.manterCursos.response.CategoriaGetResponse;
import br.com.treinamento.manterCursos.response.CursoGetResponse;
import io.swagger.annotations.ApiOperation;


@Controller
@RestController
@Transactional
public class CursoController {
	@Autowired
	private ICursoRepository cursoRepository;
	//metodo para
	private static final String ENDPOINT= "api/cursos";



	
	@RequestMapping(value=ENDPOINT, method=RequestMethod.POST)
	@ApiOperation("Serviço para cadastro de Curso")
	@CrossOrigin
	public ResponseEntity<String>post(@RequestBody CursoPostRequest request){
		try {
			Curso curso= new Curso();
			curso.setDescricao(request.getDescricao());
			curso.setDataInicio(request.getDataInicio());
			curso.setDataTermino(request.getDataTermino());
		
		

			cursoRepository.save(curso);

			return ResponseEntity.status(HttpStatus.OK).body("Curso cadastrado com sucesso.");

		} catch (Exception e) {
			return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body("Erro:"+e.getMessage());
		}
	}

	@RequestMapping(value=ENDPOINT, method=RequestMethod.PUT)
    @ApiOperation("Serviço para edição de Curso")
    @CrossOrigin
    public ResponseEntity<String>put(@RequestBody CursoPutRequest request){
        try {

            Optional<Curso> item= cursoRepository.findById(request.getIdCurso());
            if(item.isEmpty()) {
                return ResponseEntity.status(HttpStatus.BAD_REQUEST).body("Curso não encontrado");
            }else {
            	Curso curso= item.get();
    			curso.setDescricao(request.getDescricao());
    			curso.setDataInicio(request.getDataInicio());
    			curso.setDataTermino(request.getDataTermino());
    	



                cursoRepository.save(curso);
                return ResponseEntity.status(HttpStatus.OK).body("Curso atualizado com sucesso");

            }

        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body("Erro:"+e.getMessage());
        }
    }

	
	@RequestMapping(value=ENDPOINT + "/{idCurso}", method=RequestMethod.DELETE)
	@ApiOperation("Serviço para exclusão de curso")
	@CrossOrigin
	public ResponseEntity<String>delete(@PathVariable("idCurso") Integer idCurso){
		try {
			
			Optional<Curso> item= cursoRepository.findById(idCurso);
			
			if(item.isEmpty()) {
				return ResponseEntity.status(HttpStatus.BAD_REQUEST).body("Curso não encontrado");
			}else {
				Curso curso= item.get();
				cursoRepository.delete(curso);
				return ResponseEntity.status(HttpStatus.OK).body("Curso excluido com sucesso");
			}
		} catch (Exception e) {
			return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body("Erro:"+e.getMessage());
		}

	}
	
	@RequestMapping(value=ENDPOINT, method=RequestMethod.GET)
	@ApiOperation("Serviço para consulta de Curso")
	@CrossOrigin
	public ResponseEntity<List<CursoGetResponse>>get() {
		List<CursoGetResponse> response= new ArrayList<CursoGetResponse>();
		for(Curso curso: cursoRepository.findAll()) {
			CursoGetResponse item= new CursoGetResponse();
			item.setIdCurso(curso.getIdCurso());
			item.setDescricao(curso.getDescricao());
			item.setDataInicio(curso.getDataInicio());
			item.setDataTermino(curso.getDataTermino());

			response.add(item);
		}
		return ResponseEntity.status(HttpStatus.OK).body(response);
	}

	
	@RequestMapping(value=ENDPOINT + "/{idCurso}", method=RequestMethod.GET)
	@ApiOperation("Serviço para consulta de curso")
	@CrossOrigin
	public ResponseEntity<CursoGetResponse>getById(@PathVariable("idCurso") Integer idCurso) {
		Optional<Curso> item= cursoRepository.findById(idCurso);
		if(item.isEmpty()) {
			return ResponseEntity.status(HttpStatus.NOT_FOUND).body(null);
		}else {
			CursoGetResponse response= new CursoGetResponse();
			Curso curso= item.get();
			response.setIdCurso(curso.getIdCurso());
			response.setDescricao(curso.getDescricao());
			response.setDataInicio(curso.getDataInicio());
			response.setDataTermino(curso.getDataTermino());
			return ResponseEntity.status(HttpStatus.OK).body(response);

		}
	}
}
