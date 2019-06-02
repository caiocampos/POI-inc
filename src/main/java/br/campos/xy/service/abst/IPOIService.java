package br.campos.xy.service.abst;

import java.util.List;

import br.campos.xy.model.document.POIDocument;
import br.campos.xy.model.transfer.POIDTO;
import br.campos.xy.util.XYException;

/**
 * Interface de Serviço de Pontos de Interesse
 * 
 * @author Caio
 */
public interface IPOIService {

	/**
	 * Cria um Ponto de Interesse
	 * 
	 * @param dto Objeto de referência
	 * @return documento gerado
	 * @throws XYException
	 */
	POIDocument create(POIDTO dto) throws XYException;

	/**
	 * Atualiza um Ponto de Interesse
	 * 
	 * @param dto Objeto de referência
	 * @return documento gerado
	 * @throws XYException
	 */
	POIDocument update(POIDTO dto) throws XYException;

	/**
	 * Busca um Ponto de Interesse
	 * 
	 * @param dto Objeto de referência
	 * @return documento encontrado
	 * @throws XYException
	 */
	POIDocument find(POIDTO dto) throws XYException;

	/**
	 * Busca por Pontos próximos a um ponto de referência
	 * 
	 * @param x        posição X de referência
	 * @param y        posição Y de referência
	 * @param distance Distância para a busca
	 * @return lista de Pontos de Interesse
	 * @throws XYException
	 */
	List<POIDocument> find(Double x, Double y, Double distance) throws XYException;

	/**
	 * Busca todos os Pontos de Interesse
	 * 
	 * @return lista de Pontos de Interesse
	 * @throws XYException
	 */
	List<POIDocument> find() throws XYException;

	/**
	 * Busca um Ponto de Interesse
	 * 
	 * @param dto Objeto de referência
	 * @return dto do documento encontrado
	 * @throws XYException
	 */
	POIDTO findDTO(POIDTO dto) throws XYException;

	/**
	 * Busca por Pontos próximos a um ponto de referência
	 * 
	 * @param x        posição X de referência
	 * @param y        posição Y de referência
	 * @param distance Distância para a busca
	 * @return lista de Pontos de Interesse
	 * @throws XYException
	 */
	List<POIDTO> findDTO(Double x, Double y, Double distance) throws XYException;

	/**
	 * Busca todos os Pontos de Interesse
	 * 
	 * @return lista de Pontos de Interesse
	 * @throws XYException
	 */
	List<POIDTO> findDTO() throws XYException;

	/**
	 * Apaga um Ponto de Interesse
	 * 
	 * @param dto Objeto de referência
	 * @throws XYException
	 */
	void delete(POIDTO dto) throws XYException;

	/**
	 * Apaga todos os Pontos de Interesse
	 * 
	 * @throws XYException
	 */
	void deleteAll() throws XYException;
}
