 create table aplicacao_fundo_renda_variavel (
       cod bigint not null,
        corretora_enum varchar(255),
        data_aplicacao datetime,
        nome_fundo varchar(255),
        tipo_fundo_enum varchar(255),
        valor_aplicado decimal(19,2),
        valor_corretagem decimal(19,2),
        num_versao_registro bigint not null,
        cod_carteira bigint not null,
        primary key (cod)
    ) engine=MyISAM;


    create table aplicacao_previdencia_privada (
       cod bigint not null,
        cnpj_entidade_financeira varchar(255),
        nome_entidade_financeira varchar(255),
        data_aplicacao datetime,
        valor_aplicado decimal(19,2),
        num_versao_registro bigint not null,
        primary key (cod)
    ) engine=MyISAM;


    create table aplicacao_renda_fixa (
       cod bigint not null,
        corretora_enum varchar(255),
        cnpj_entidade_financeira varchar(255),
        nome_entidade_financeira varchar(255),
        data_aplicacao datetime,
        data_vencimento datetime,
        nome_fundo varchar(255),
        taxacdi float not null,
        tipo_aplicacao_renda_fixa_enum varchar(255),
        valor_aplicado decimal(19,2),
        valor_corretagem decimal(19,2),
        num_versao_registro bigint not null,
        cod_carteira bigint not null,
        primary key (cod)
    ) engine=MyISAM;


    create table aplicacao_super_previdencia (
       cod bigint not null,
        data_aplicacao datetime,
        valor_aplicado decimal(19,2),
        num_versao_registro bigint not null,
        cod_carteira bigint not null,
        primary key (cod)
    ) engine=MyISAM;


    create table aplicacao_tesouro_direto (
       cod bigint not null,
        corretora_enum varchar(255),
        data_aplicacao datetime,
        preco_unitario decimal(19,2),
        taxa_juros float not null,
        tipo_titulo_tesouro_direto_enum varchar(255),
        valor_aplicado decimal(19,2),
        valor_corretagem decimal(19,2),
        num_versao_registro bigint not null,
        cod_carteira bigint not null,
        primary key (cod)
    ) engine=MyISAM;


    create table carteira (
       cod bigint not null,
        num_versao_registro bigint not null,
        primary key (cod)
    ) engine=MyISAM;


    create table creditos_diversos (
       cod bigint not null,
        data_concessao_credito datetime,
        tipo_credito varchar(255),
        valor_credito decimal(19,2),
        num_versao_registro bigint not null,
        cod_carteira bigint not null,
        primary key (cod)
    ) engine=MyISAM;


    create table ordem_compra_papel_renda_variavel (
       cod bigint not null,
        corretora varchar(255),
        data_compra datetime,
        cnpj varchar(255),
        ticker varchar(255),
        tipo_bolsa_enum varchar(255),
        tipo_ramo_investimento_enum varchar(255),
        tipo_renda_variavel_enum varchar(255),
        preco_unitario decimal(19,2),
        quantidade double precision not null,
        valor_corretagem decimal(19,2),
        num_versao_registro bigint not null,
        cod_carteira bigint not null,
        primary key (cod)
    ) engine=MyISAM;


    create table percentual_participacao_super_previdencia (
       cod bigint not null,
        percentual float not null,
        num_versao_registro bigint not null,
        cod_aplicacao_prev_privada bigint,
        cod_aplicacao_super_prev bigint,
        primary key (cod)
    ) engine=MyISAM;


    create table rendimento (
       cod bigint not null,
        data_pagamento datetime,
        tipo_rendimento varchar(255),
        valor decimal(19,2),
        num_versao_registro bigint not null,
        primary key (cod)
    ) engine=MyISAM;


    create table seq_aplicacao_prev_privada (
       next_val bigint
    ) engine=MyISAM;


    insert into seq_aplicacao_prev_privada values ( 1 );


    create table seq_aplicacao_renda_fixa (
       next_val bigint
    ) engine=MyISAM;


    insert into seq_aplicacao_renda_fixa values ( 1 );


    create table seq_aplicacao_renda_variavel (
       next_val bigint
    ) engine=MyISAM;


    insert into seq_aplicacao_renda_variavel values ( 1 );


    create table seq_aplicacao_super_prev (
       next_val bigint
    ) engine=MyISAM;


    insert into seq_aplicacao_super_prev values ( 1 );


    create table seq_aplicacao_tesouro_direto (
       next_val bigint
    ) engine=MyISAM;


    insert into seq_aplicacao_tesouro_direto values ( 1 );


    create table seq_carteira (
       next_val bigint
    ) engine=MyISAM;


    insert into seq_carteira values ( 1 );


    create table seq_creditos_diversos (
       next_val bigint
    ) engine=MyISAM;


    insert into seq_creditos_diversos values ( 1 );


    create table seq_ordem_compra_papel_rv (
       next_val bigint
    ) engine=MyISAM;


    insert into seq_ordem_compra_papel_rv values ( 1 );


    create table seq_percentual_partic_super_prev (
       next_val bigint
    ) engine=MyISAM;


    insert into seq_percentual_partic_super_prev values ( 1 );


    create table seq_rendimento (
       next_val bigint
    ) engine=MyISAM;


    insert into seq_rendimento values ( 1 );


    alter table aplicacao_fundo_renda_variavel
       add constraint FKf99nvunis68da2vh1guyucbtg
       foreign key (cod_carteira)
       references carteira (cod);


    alter table aplicacao_renda_fixa
       add constraint FKcf0q87pw0as1jd7o9lwjxg573
       foreign key (cod_carteira)
       references carteira (cod);


    alter table aplicacao_super_previdencia
       add constraint FKoj4fkk11y1ko4qfxag9gmpf73
       foreign key (cod_carteira)
       references carteira (cod);


    alter table aplicacao_tesouro_direto
       add constraint FKnenqjts8d0caqpr4jt2abvwcv
       foreign key (cod_carteira)
       references carteira (cod);


    alter table creditos_diversos
       add constraint FKowgcvee1o36psd5dgnuua0h83
       foreign key (cod_carteira)
       references carteira (cod);


    alter table ordem_compra_papel_renda_variavel
       add constraint FK2bdga75iglf5dh1d083ibo9rk
       foreign key (cod_carteira)
       references carteira (cod);


    alter table percentual_participacao_super_previdencia
       add constraint FK2ilx4fnmvhpewytapc1apsseg
       foreign key (cod_aplicacao_prev_privada)
       references aplicacao_previdencia_privada (cod);


    alter table percentual_participacao_super_previdencia
       add constraint FK1cj3bllm90h563jfk9c4ehwjy
       foreign key (cod_aplicacao_super_prev)
       references aplicacao_super_previdencia (cod);