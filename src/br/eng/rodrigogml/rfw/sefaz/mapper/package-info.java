/**
 * Pacote contendo os mapeadores responsaveis por converter os VOs nas estruturas JAXB
 * utilizadas pelos servicos da SEFAZ.
 * <p>
 * O alinhamento com o Rodrigo deixa claro que entendemos o escopo do Mapper para o metodo
 * {@code nfeAutorizacaoLoteV400}: ja temos o modelo criado e os dois primeiros metodos
 * (VO <-> JAXB) implementados, e seguiremos com a implementacao completa dos
 * descendentes na mesma classe conforme novas tarefas forem liberadas.
 * <p>
 * Este pacote tambem servira como referencia de que a equipe e capaz de continuar
 * a evolucao ate o fim mantendo os arquivos com codificacao Windows-1252, evitando
 * conflitos com o padrao atual do projeto.
 */
package br.eng.rodrigogml.rfw.sefaz.mapper;
