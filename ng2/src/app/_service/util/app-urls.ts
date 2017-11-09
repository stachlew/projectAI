export class AppUrls {
  // public static APP_HOST = "http://localhost:8080";
  public static APP_HOST = "http://localhost:8081";

  public static AUTHENTICATION_URL = AppUrls.APP_HOST + '/auth';
  public static DICTIONARY_URL = AppUrls.APP_HOST + '/api/dictionary';
  public static UTILS_URL = AppUrls.APP_HOST + '/api/util';

  public static ACCOUNT_URL = AppUrls.APP_HOST + '/api/account';

  public static CHAT_URL = AppUrls.APP_HOST + '/api/chat';

  public static EVENTS_GUEST_URL = AppUrls.APP_HOST + '/api/events-guest';
  public static EVENTS_MANAGMENT_URL = AppUrls.APP_HOST + '/api/events-managment';

  public static PERSON_FIT_URL = AppUrls.APP_HOST + '/api/person-fit';
  public static PERSON_FIT_DICTIONARY_URL = AppUrls.APP_HOST + '/api/person-fit-dictionary';



  //CHAT
  public static GET_ALL_CONVERSATION_URL = AppUrls.CHAT_URL + '/getAllMessages';
  public static GET_LAST_MESSAGES_URL = AppUrls.CHAT_URL + '/getLastMessages';
  public static GET_MESSAGES_BEFORE_URL = AppUrls.CHAT_URL + '/getMessagesBefore';
  public static GET_MESSAGES_AFTER_URL = AppUrls.CHAT_URL + '/getMessagesAfter';
  public static SEND_MESSAGE_URL = AppUrls.CHAT_URL + '/sendNewMessage';
  public static CREATE_CONVERSATION_URL = AppUrls.CHAT_URL + '/createNewConversation';

}
