package br.com.desafioalura.conversor;

public class ExchangerateApiConfig {
    private static final String API_KEY = System.getenv("EXCHANGERATE-API");

    public static String getApiKey(){
        if(API_KEY == null || API_KEY.isEmpty()){
            throw new IllegalStateException("Chave da EXCHANGERATE-API não configurada!");
        }

        return API_KEY;
    }
}
