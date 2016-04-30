package br.com.sharktech.forca.bancodados;

public class ScriptsSQL {
    public static String TAB_CLI_PALAVRA = "CLI_PALAVRA", TAB_CLI_USUARIO = "CLI_USUARIO", TAB_CLI_CATEGORIA = "CLI_CATEGORIA",
            TAB_CLI_PALAVRAS_ACERTADAS_POR_USUARIO = "CLI_PALAVRAS_ACERTADAS_USUARIO", TAB_CLI_AMIGOS_USUARIO = "CLI_USUARIO_AMIGOS";
    public static String COL_ID_GERAL = "_id",COL_DESCRICAO_TAB_CLI_CATEGORIA = "Descricao", COL_PALAVRA_TAB_CLI_PALAVRA = "Palavra",
            COL_PONTUACAO_GERAL_TAB_CLI_PALAVRA = "PontuacaoGeral", COL_PONTUACAO_DIARIA_TAB_CLI_PALAVRA = "PontuacaoDiaria",
            COL_ID_CATEGORIA_TAB_CLI_PALAVRA = "idCLI_CATEGORIA", COL_ID_USUARIO_CRIADOR_PALAVRA_TAB_CLI_PALAVRA = "idCLI_USUARIO_CriadorPalavra",
            COL_ID_PALAVRA_TAB_CLI_PALAVRAS_ACERTADAS_POR_USUARIO = "CLI_PALAVRA_idCLI_PALAVRA",
            COL_ID_USUARIO_TAB_CLI_ACERTADAS_POR_USUARIO = "CLI_PALAVRAS_ACERTADAS_USUARIO", COL_NOME_TAB_CLI_USUARIO = "Nome",
            COL_EMAIL_TAB_CLI_USUARIO = "Email", COL_PONTUACAO_GERAL_TAB_CLI_USUARIO = "PontuacaoGeral",
            COL_PONTUACAO_DIARIA_TAB_CLI_USUARIO = "PontuacaoDiaria", COL_PALAVRAS_DESCOBERTAS_TAB_CLI_USUARIO = "PalavrasDescobertas",
            COL_ID_USUARIO_CLI_USUARIO_AMIGOS = "CLI_USUARIO_idCLI_USUARIO", COL_ID_USUARIO_1_CLI_USUARIO_AMIGOS = "CLI_USUARIO_idCLI_USUARIO1";
    public static String MET_CREATE_TABLE = "CREATE TABLE IF NOT EXISTS ", MET_SELECT = "SELECT ", MET_INSERT = "INSERT INTO ", MET_DROP_TABLE = "DROP TABLE IF EXISTS ";

    public static String getCreateTableUsuario(){
        StringBuilder sqlBuilder = new StringBuilder();
        sqlBuilder.append(MET_CREATE_TABLE+TAB_CLI_USUARIO+" ( ");
        sqlBuilder.append(COL_ID_GERAL+" INTEGER NOT NULL PRIMARY KEY AUTOINCREMENT, ");
        sqlBuilder.append(COL_NOME_TAB_CLI_USUARIO+" VARCHAR(50) NOT NULL, ");
        sqlBuilder.append(COL_EMAIL_TAB_CLI_USUARIO+" VARCHAR(50), ");
        sqlBuilder.append(COL_PONTUACAO_GERAL_TAB_CLI_USUARIO+" INTEGER, ");
        sqlBuilder.append(COL_PONTUACAO_DIARIA_TAB_CLI_USUARIO+" INTEGER, ");
        sqlBuilder.append(COL_PALAVRAS_DESCOBERTAS_TAB_CLI_USUARIO+" INTEGER ");
        sqlBuilder.append(");");

        return sqlBuilder.toString();
    }

    public static String getCreateTablePalavra(){
        StringBuilder sqlBuilder = new StringBuilder();
        sqlBuilder.append(MET_CREATE_TABLE+TAB_CLI_PALAVRA+" ( ");
        sqlBuilder.append(COL_ID_GERAL+" INTEGER NOT NULL PRIMARY KEY AUTOINCREMENT, ");
        sqlBuilder.append(COL_PALAVRA_TAB_CLI_PALAVRA+" VARCHAR(50) NOT NULL, ");
        sqlBuilder.append(COL_PONTUACAO_GERAL_TAB_CLI_PALAVRA+" INTEGER, ");
        sqlBuilder.append(COL_PONTUACAO_DIARIA_TAB_CLI_PALAVRA+" INTEGER, ");
        sqlBuilder.append(COL_ID_CATEGORIA_TAB_CLI_PALAVRA+" INTEGER NOT NULL, ");
        sqlBuilder.append(COL_ID_USUARIO_CRIADOR_PALAVRA_TAB_CLI_PALAVRA+" INTEGER ");
        sqlBuilder.append(");");

        return  sqlBuilder.toString();
    }

    public static String getCreateTableCategoria(){
        StringBuilder sqlBuilder = new StringBuilder();
        sqlBuilder.append(MET_CREATE_TABLE+TAB_CLI_CATEGORIA+" ( ");
        sqlBuilder.append(COL_ID_GERAL+" INTEGER NOT NULL PRIMARY KEY AUTOINCREMENT, ");
        sqlBuilder.append(COL_DESCRICAO_TAB_CLI_CATEGORIA+" VARCHAR(50) NOT NULL ");
        sqlBuilder.append(");");

        return  sqlBuilder.toString();
    }

    public static String getCreateTablePalavrasAcertadasPorUsuario(){
        StringBuilder sqlBuilder = new StringBuilder();
        sqlBuilder.append(MET_CREATE_TABLE+TAB_CLI_PALAVRAS_ACERTADAS_POR_USUARIO+" ( ");
        sqlBuilder.append(COL_ID_PALAVRA_TAB_CLI_PALAVRAS_ACERTADAS_POR_USUARIO+" INTEGER NOT NULL, ");
        sqlBuilder.append(COL_ID_USUARIO_TAB_CLI_ACERTADAS_POR_USUARIO+" INTEGER NOT NULL ");
        sqlBuilder.append(");");

        return  sqlBuilder.toString();
    }

    public static String getCreateTableUsuarioAmigos(){
        StringBuilder sqlBuilder = new StringBuilder();
        sqlBuilder.append(MET_CREATE_TABLE+TAB_CLI_AMIGOS_USUARIO+" ( ");
        sqlBuilder.append(COL_ID_USUARIO_CLI_USUARIO_AMIGOS+" INTEGER NOT NULL, ");
        sqlBuilder.append(COL_ID_USUARIO_1_CLI_USUARIO_AMIGOS+" INTEGER NOT NULL ");
        sqlBuilder.append(");");

        return  sqlBuilder.toString();
    }

    public static String getDropTableCategoria(){
        return MET_DROP_TABLE+TAB_CLI_CATEGORIA+";";
    }

    public static String getDropTablePalavra(){
        return MET_DROP_TABLE+TAB_CLI_PALAVRA+";";
    }

    public static String getDropTableUsuario(){
        return MET_DROP_TABLE+TAB_CLI_USUARIO+";";
    }

    public static String getDropTableAmigosUsuario(){
        return MET_DROP_TABLE+TAB_CLI_AMIGOS_USUARIO+";";
    }

    public static String getDropTablePalavrasAcertadasUsuario(){
        return MET_DROP_TABLE+TAB_CLI_PALAVRAS_ACERTADAS_POR_USUARIO+";";
    }


}
