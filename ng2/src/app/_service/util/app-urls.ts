export class AppUrls {
  // public static APP_HOST = "http://localhost:8080";
  public static APP_HOST = "http://localhost:8081";

  public static AUTHENTICATION_URL = AppUrls.APP_HOST + '/auth';

  public static UTILS_URL = AppUrls.APP_HOST + '/api/util';

  //UTILS
  public static UTILS_USER_COUNT_URL = AppUrls.UTILS_URL + '/countActiveUsers';

  //FOTO
  public static USER_IMAGE_URL = AppUrls.APP_HOST + '/api/images/users/';
  public static EVENT_IMAGE_URL = AppUrls.APP_HOST + '/api/images/events/';
  public static UPLOAD_EVENT_IMAGE_URL = AppUrls.APP_HOST + '/api/images/upload-event-photo/';
  public static DELETE_EVENT_IMAGE_URL = AppUrls.APP_HOST + '/api/images/delete-event-photo/';
  public static UPLOAD_USER_IMAGE_URL = AppUrls.APP_HOST + '/api/images/upload-user-photo';
  public static DELETE_USER_IMAGE_URL = AppUrls.APP_HOST + '/api/images/delete-user-photo';

  //CHAT
  public static CHAT_URL = AppUrls.APP_HOST + '/api/chat';
  public static GET_ALL_CONVERSATION_URL = AppUrls.CHAT_URL + '/getAllConversations';
  public static GET_LAST_MESSAGES_URL = AppUrls.CHAT_URL + '/getLastMessages';
  public static GET_MESSAGES_BEFORE_URL = AppUrls.CHAT_URL + '/getMessagesBefore';
  public static GET_MESSAGES_AFTER_URL = AppUrls.CHAT_URL + '/getMessagesAfter';
  public static SEND_MESSAGE_URL = AppUrls.CHAT_URL + '/sendNewMessage';
  public static CREATE_CONVERSATION_URL = AppUrls.CHAT_URL + '/createNewConversation';

  //EVENTS
  public static EVENTS_GUEST_URL = AppUrls.APP_HOST + '/api/events-guest';
  public static GUEST_GET_ALL_EVENTS_URL = AppUrls.EVENTS_GUEST_URL + '/getEvents';
  public static GUEST_GET_PARTICIPATION_EVENTS_URL = AppUrls.EVENTS_GUEST_URL + '/getUserParticipantEvent';
  public static GUEST_SAVE_PARTICIPATION_URL = AppUrls.EVENTS_GUEST_URL + '/saveParticipant';
  public static GUEST_DELETE_PARTICIPATION_URL = AppUrls.EVENTS_GUEST_URL + '/deleteParticipant';
  public static GUEST_GET_EVENT_DETAILS_URL = AppUrls.EVENTS_GUEST_URL + '/getDetails';

  public static EVENTS_MANAGMENT_URL = AppUrls.APP_HOST + '/api/events-managment';
  public static EVENTS_SAVE_URL = AppUrls.EVENTS_MANAGMENT_URL + '/save-event';
  public static EVENTS_LIST_URL = AppUrls.EVENTS_MANAGMENT_URL + '/manager-events';
  public static EVENTS_DETAIL_URL = AppUrls.EVENTS_MANAGMENT_URL + '/get-details/';


  //DICTIONARY
  public static DICTIONARY_URL = AppUrls.APP_HOST + '/api/dictionary';
  public static GET_REGIONS_URL = AppUrls.DICTIONARY_URL + '/getRegions';
  public static GET_CITIES_URL = AppUrls.DICTIONARY_URL + '/getCities';

  //USER
  public static ACCOUNT_URL = AppUrls.APP_HOST + '/api/account';
  public static REGISTER_ACCOUNT_URL = AppUrls.ACCOUNT_URL + '/createNewUser';
  public static GET_ACCOUNT_INFO_URL = AppUrls.ACCOUNT_URL + '/getAccountInfo';
  public static CHANGE_PASSWORD_URL = AppUrls.ACCOUNT_URL + '/changePassword';
  public static CHANGE_LOCALIZATION_URL = AppUrls.ACCOUNT_URL + '/changeLocalization';


  //PROFILE
  public static PERSON_FIT_URL = AppUrls.APP_HOST + '/api/person-fit';
  public static PERSON_FIT_DICTIONARY_URL = AppUrls.APP_HOST + '/api/person-fit-dictionary';
  public static PERSONS_URL = AppUrls.APP_HOST + '/api/person';
  public static PERSONS_GET_PROFILES_LIST = AppUrls.PERSONS_URL + '/getProfilesList';
}
