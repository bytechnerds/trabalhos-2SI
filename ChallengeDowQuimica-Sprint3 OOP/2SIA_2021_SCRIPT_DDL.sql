CREATE TABLE usuario (
    id_usuario          INTEGER NOT NULL,
    nome                VARCHAR2(70 CHAR) NOT NULL,
    email               VARCHAR2(50 CHAR) NOT NULL,
    senha               VARCHAR2(20 CHAR) NOT NULL,
    navegador           VARCHAR2(20 CHAR) NOT NULL,
    deficiencia_visual  VARCHAR2(30 CHAR) NOT NULL
);

CREATE TABLE configuracoes (
    id_configuracoes    INTEGER NOT NULL,
    atalhos_teclado     CLOB,
    modo_descricao      CLOB,
    leitor_de_tela      VARCHAR2(20) NOT NULL,
    usuario_id_usuario  INTEGER NOT NULL
);

CREATE TABLE feedback (
    id_feedback         INTEGER NOT NULL,
    assunto             VARCHAR2(30 CHAR),
    texto               VARCHAR2(300 CHAR) NOT NULL,
    usuario_id_usuario  INTEGER NOT NULL
);

CREATE TABLE sessao (
    id_sessao           INTEGER NOT NULL,
    data_acesso         DATE NOT NULL,
    duracao             DATE NOT NULL,
    funcoes             CLOB NOT NULL,
    sites_id_site       INTEGER NOT NULL,
    usuario_id_usuario  INTEGER NOT NULL
);

CREATE TABLE sites (
    id_site            INTEGER NOT NULL,
    uri                VARCHAR2(200) NOT NULL,
    numero_de_acessos  INTEGER NOT NULL
);


CREATE UNIQUE INDEX configuracoes__idx ON
    configuracoes (
        usuario_id_usuario
    ASC );

ALTER TABLE configuracoes ADD CONSTRAINT configuracoes_pk PRIMARY KEY ( id_configuracoes );

ALTER TABLE feedback ADD CONSTRAINT feedback_pk PRIMARY KEY ( id_feedback,
                                                              usuario_id_usuario );

ALTER TABLE sessao ADD CONSTRAINT sessao_pk PRIMARY KEY ( id_sessao );

ALTER TABLE sites ADD CONSTRAINT sites_pk PRIMARY KEY ( id_site );

ALTER TABLE usuario ADD CONSTRAINT usuario_pk PRIMARY KEY ( id_usuario );

ALTER TABLE usuario ADD CONSTRAINT usuario__un UNIQUE ( email );

ALTER TABLE configuracoes
    ADD CONSTRAINT configuracoes_usuario_fk FOREIGN KEY ( usuario_id_usuario )
        REFERENCES usuario ( id_usuario );

ALTER TABLE feedback
    ADD CONSTRAINT feedback_usuario_fk FOREIGN KEY ( usuario_id_usuario )
        REFERENCES usuario ( id_usuario );

ALTER TABLE sessao
    ADD CONSTRAINT sessao_sites_fk FOREIGN KEY ( sites_id_site )
        REFERENCES sites ( id_site );

ALTER TABLE sessao
    ADD CONSTRAINT sessao_usuario_fk FOREIGN KEY ( usuario_id_usuario )
        REFERENCES usuario ( id_usuario );

