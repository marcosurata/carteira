create table aplicacao_fundo_renda_variavel (
  cod bigint not null auto_increment,
  corretora varchar(255),
  data_aplicacao datetime not null,
  nome_fundo varchar(255) not null,
  tipo_fundo varchar(255) not null,
  valor_aplicado decimal(19,2) not null,
  valor_corretagem decimal(19,2),
  num_versao_registro bigint not null,
  cod_carteira bigint,
  primary key (cod)
) engine=MyISAM
;

create table aplicacao_previdencia_privada (
  cod bigint not null auto_increment,
  cnpj_entidade_financeira varchar(255),
  nome_entidade_financeira varchar(255) not null,
  data_aplicacao datetime,
  valor_aplicado decimal(19,2),
  num_versao_registro bigint not null,
  primary key (cod)
) engine=MyISAM
;

create table aplicacao_renda_fixa (
  cod bigint not null auto_increment,
  corretora varchar(255),
  cnpj_entidade_financeira varchar(255),
  nome_entidade_financeira varchar(255) not null,
  data_aplicacao datetime not null,
  data_vencimento datetime,
  nome_fundo varchar(255) not null,
  taxacdi float not null,
  tipo_aplicacao_renda_fixa varchar(255) not null,
  valor_aplicado decimal(19,2) not null,
  valor_corretagem decimal(19,2),
  num_versao_registro bigint not null,
  cod_carteira bigint,
  primary key (cod)
) engine=MyISAM
;

create table aplicacao_super_previdencia (
  cod bigint not null auto_increment,
  data_aplicacao datetime,
  valor_aplicado decimal(19,2),
  num_versao_registro bigint not null,
  cod_carteira bigint,
  primary key (cod)
) engine=MyISAM
;

create table aplicacao_tesouro_direto (
  cod bigint not null auto_increment,
  corretora varchar(255),
  data_aplicacao datetime,
  preco_unitario decimal(19,2),
  taxa_juros float not null,
  tipo_titulo_tesouro_direto varchar(255),
  valor_aplicado decimal(19,2),
  valor_corretagem decimal(19,2),
  num_versao_registro bigint not null,
  cod_carteira bigint,
  primary key (cod)
) engine=MyISAM
;

create table carteira (
  cod bigint not null auto_increment,
  num_versao_registro bigint not null,
  cod_usuario bigint,
  primary key (cod)
) engine=MyISAM
;

create table creditos_diversos (
  cod bigint not null auto_increment,
  data_concessao_credito datetime,
  tipo_credito varchar(255),
  valor_credito decimal(19,2),
  num_versao_registro bigint not null,
  cod_carteira bigint,
  primary key (cod)
) engine=MyISAM
;

create table hibernate_sequence (
  next_val bigint
) engine=MyISAM
;

insert into hibernate_sequence values ( 1 )
;

create table ordem_compra_papel_renda_variavel (
  cod bigint not null auto_increment,
  corretora varchar(255) not null,
  data_compra datetime not null,
  preco_unitario decimal(19,2) not null,
  quantidade double precision not null,
  valor_corretagem decimal(19,2),
  num_versao_registro bigint not null,
  cod_carteira bigint,
  cod_papel bigint,
  primary key (cod)
) engine=MyISAM
;

create table papel_renda_variavel (
  cod bigint not null auto_increment,
  cnpj varchar(255),
  descricao varchar(255),
  ticker varchar(255) not null,
  tipo_bolsa varchar(255) not null,
  tipo_ramo_investimento varchar(255),
  tipo_renda_variavel varchar(255) not null,
  num_versao_registro bigint not null,
  primary key (cod)
) engine=MyISAM
;

create table percentual_participacao_super_previdencia (
  cod bigint not null auto_increment,
  percentual float not null,
  num_versao_registro bigint not null,
  cod_aplicacao_prev_privada bigint,
  cod_aplicacao_super_prev bigint,
  primary key (cod)
) engine=MyISAM
;

create table rendimento (
  cod bigint not null,
  data_pagamento datetime not null,
  tipo_rendimento varchar(255),
  valor decimal(19,2) not null,
  num_versao_registro bigint not null,
  primary key (cod)
) engine=MyISAM
;

create table usuario (
  cod bigint not null auto_increment,
  data_cadastro datetime,
  login varchar(255),
  nome varchar(255),
  senha varchar(255),
  num_versao_registro bigint not null,
  primary key (cod)
) engine=MyISAM
;

alter table aplicacao_fundo_renda_variavel
  add constraint FK_AFRV_COD_CARTEIRA
foreign key (cod_carteira)
references carteira (cod)
;

alter table aplicacao_renda_fixa
  add constraint FK_ARF_COD_CARTEIRA
foreign key (cod_carteira)
references carteira (cod)
;

alter table aplicacao_super_previdencia
  add constraint FK_ASP_COD_CARTEIRA
foreign key (cod_carteira)
references carteira (cod)
;

alter table aplicacao_tesouro_direto
  add constraint FK_ATD_COD_CARTEIRA
foreign key (cod_carteira)
references carteira (cod)
;

alter table carteira
  add constraint FK_CARTEIRA_USUARIO
foreign key (cod_usuario)
references usuario (cod)
;

alter table creditos_diversos
  add constraint FK_CD_COD_CARTEIRA
foreign key (cod_carteira)
references carteira (cod)
;

alter table ordem_compra_papel_renda_variavel
  add constraint FK_OCPRV_COD_CARTEIRA
foreign key (cod_carteira)
references carteira (cod)
;

alter table ordem_compra_papel_renda_variavel
  add constraint FK_OCPRV_COD_PAPEL
foreign key (cod_papel)
references papel_renda_variavel (cod)
;

alter table percentual_participacao_super_previdencia
  add constraint FK_PPSP_COD_APP
foreign key (cod_aplicacao_prev_privada)
references aplicacao_previdencia_privada (cod)
;

alter table percentual_participacao_super_previdencia
  add constraint FK_PPSP_COD_ASP
foreign key (cod_aplicacao_super_prev)
references aplicacao_super_previdencia (cod);