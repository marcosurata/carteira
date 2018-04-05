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

alter table aplicacao_fundo_renda_variavel
  add constraint FKf99nvunis68da2vh1guyucbtg
foreign key (cod_carteira)
references carteira (cod)
;

alter table aplicacao_renda_fixa
  add constraint FKcf0q87pw0as1jd7o9lwjxg573
foreign key (cod_carteira)
references carteira (cod)
;

alter table aplicacao_super_previdencia
  add constraint FKoj4fkk11y1ko4qfxag9gmpf73
foreign key (cod_carteira)
references carteira (cod)
;

alter table aplicacao_tesouro_direto
  add constraint FKnenqjts8d0caqpr4jt2abvwcv
foreign key (cod_carteira)
references carteira (cod)
;

alter table creditos_diversos
  add constraint FKowgcvee1o36psd5dgnuua0h83
foreign key (cod_carteira)
references carteira (cod)
;

alter table ordem_compra_papel_renda_variavel
  add constraint FK2bdga75iglf5dh1d083ibo9rk
foreign key (cod_carteira)
references carteira (cod)
;

alter table ordem_compra_papel_renda_variavel
  add constraint FK7f6p8njis96ekd1s2f5j1yjpy
foreign key (cod_papel)
references papel_renda_variavel (cod)
;

alter table percentual_participacao_super_previdencia
  add constraint FK2ilx4fnmvhpewytapc1apsseg
foreign key (cod_aplicacao_prev_privada)
references aplicacao_previdencia_privada (cod)
;

alter table percentual_participacao_super_previdencia
  add constraint FK1cj3bllm90h563jfk9c4ehwjy
foreign key (cod_aplicacao_super_prev)
references aplicacao_super_previdencia (cod)
;