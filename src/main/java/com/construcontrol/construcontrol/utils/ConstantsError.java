package com.construcontrol.construcontrol.utils;

public final class ConstantsError {
    public static final String MESSAGE_LOGIN = "Login não pode ser nulo";
    public static final String MESSAGE_PASSWORD_SIZE = "Senha deve conter no mínimo 8 dígitos";
    public static final String MESSAGE_PASSWORD_BLANK = "Senha não pode ser nula";
    public static final String MESSAGE_USER_ROLE_BLANK = "Campo UserRole não pode ser nulo";
    public static final String MESSAGE_USERNAME_BLANK = "Nome não pode ser nulo";
    public static final String MESSAGE_USERNAME_LENGTH = "Nome precisa ter entre 2 a 50 caracteres";
    public static final String MESSAGE_CPF_BLANK = "CPF não pode ser nulo";
    public static final String MESSAGE_CPF = "O CPF informado é inválido";
    public static final String MESSAGE_EMAIL_BLANK = "Email não pode ser nulo";
    public static final String MESSAGE_EMAIL_FORMAT = "Formato de email inválido";
    public static final String MESSAGE_PHONE_SIZE = "Telefone deve conter 11 dígitos";
    public static final String MESSAGE_CEP_BLANK = "CEP não pode ser nulo";
    public static final String MESSAGE_CEP_SIZE = "CEP deve conter 8 dígitos";
    public static final String MESSAGE_STREET_BLANK = "Nome da rua não pode ser vazia";
    public static final String MESSAGE_NEIGHBORHOOD_BLANK = "Nome do bairro não pode ser vazio";
    public static final String MESSAGE_LOCATION_BLANK = "Localidade não pode ser vazia";
    public static final String MESSAGE_UF_BLANK = "Sigla UF não pode ser vazia";
    public static final String MESSAGE_NUMBER_APARTMENT_BLANK = "Número do apartamento não pode ser vazio";
    public static final String MESSAGE_AREA_APARTMENT_BLANK = "Área do apartamento não pode ser vazia";
    public static final String MESSAGE_PRICE_APARTMENT_BLANK = "Valor do apartamento não pode ser vazio";
    public static final String MESSAGE_SOLD_STATUS_APARTMENT_BLANK = "Status de venda do apartamento não pode ser vazio";
    public static final String MESSAGE_COMPANY_NAME_BLANK = "Nome da empresa não pode ser vazio";
    public static final String MESSAGE_CNPJ = "O CNPJ informado é inválido.";
    public static final String MESSAGE_CNPJ_BLANK = "CNPJ não pode ser vazio";
    public static final String MESSAGE_NAME_CONSTRUCTION_BLANK = "Nome da construção não pode ser vazio";
    public static final String MESSAGE_START_DATE_BLANK = "Data de início não pode ser vazia";
    public static final String MESSAGE_END_DATE_BLANK = "Data de término não pode ser vazia";
    public static final int USERNAME_MIN_LENGTH = 2;
    public static final int USERNAME_MAX_LENGTH = 50;
    public static final int CPF_LENGTH = 11;
    public static final int PASSWORD_MIN_LENGTH = 8;
    public static final int PHONE_MIN_LENGTH = 11;
    public static final int CEP_LENGTH = 8;

    private ConstantsError() {
        throw new UnsupportedOperationException("Essa classe não pode ser instanciada");
    }
}
