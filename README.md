# Dashboard ACR - Estrutura do projeto de microsserviços
Explicação superficial com base na representação visual anexada.

Alunos: Kielson Zinn da Silva, Maria Gabriela Silvano e André Lucas Ruiz Almeida

### Dashboard DB
Irá ter tabelas para:
```
grupos (id e nome)
projetos (id, nome, url to clone e branch)
usuarios (id, nome, email)
issues (id, id_project, arquivo, linha_inicio, linha_fim, descrição, tipo_issue)
execuções (id, id_projeto, nr_tentativa, tp_status, qt_issue_encontrada, dh_inicio_execucao, dh_fim_execucao)
```

### Dashboard gestão API
Irá ter APIs para disponibilizar os CRUDs para as tabelas acima

### Dashboard AUTH
API de autenticação, sendo possível gerar token a partir do usuário gravado no banco AUTH, e validar se um token é válido.

### AUTH DB
Irá ter apenas uma tabela a princípio:
```
usuarios (id, nome, email, password)
```
No futuro, poderá ter controle de acesso.

### Dashboard Runner
Será uma thread que não expõe nada, apenas fica consultando a cada período de  tempo, se existem execuções pendentes. Se sim executa, e grava o resultado em banco.
No futuro, podemos substituir a thread por um serviço de fila.


### Explicação sobre o funcionamento:
Imagine que tenho o projeto X cadastrado no banco, e quero executar uma verificação nele, e listar todas as Issues que o ACR (Automatic code review) comentaria no merge request.
Vou rodar lá e pesquiso pelo projeto X via tela usando o Dashboard gestão API
O Runner vai pegar, clonar o projeto, e rodar várias extensões (que ficarão em um outro projeto) e depois disso inserir no banco.
Com isso, via tela vou conseguir ver as Issues encontradas, como por exemplo, TODOs fora do padrão definido, uso de funções deprecated, etc...

OBS: Para compreender melhor o funcionamento do Runner, dê uma lida na documentação oficial do projeto: https://github.com/automatic-code-review/docs/wiki
