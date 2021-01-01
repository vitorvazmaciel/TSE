# TSE
Um Script desenvolvido em JAVA, que realiza uma cópia do Bando de Dados em PostgreSQL dos candidatos participantes da eleição do TSE.

Para realizar o uso do Script, primeiramente crie um Banco De Dados no PostgreSQL (Foi usado a versão 13.1) e use o arquivo dump.sql disponibilizado no repositório para a criação das tabelas.

Segundamente, descompacte os arquivos candidatos.zip (São 8607 arquivos de dados eleitorais disponibilizados pelo TSE em formato JSON, cada um contendo as informações de cada candidato) e org.zip (Bibliotecas externas usadas pelo Script, como por exemplo o JSONObject, JSONArray e o Driver de conexão do PostgreSQL) na mesma pasta do Script.

Por fim, compile o Script e execute-o, passando a URL, usuário e senha do Banco de Dados criado. O tempo de execução é aproximadamente 1 minuto, após o fim da execução, seu Bando de Dados já estará populado com as informações de 8607 candidatos do TSE.

