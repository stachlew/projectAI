import { Injectable } from '@angular/core';

@Injectable()
export class PersonListService {

  constructor() { }


  getPersons(pageNo: number, size: number){
    let personsMain = [
      {
        id:1,
        name: 'Kateryna',
        age: 22,
        region: 'Mazowieckie',
        city: 'Warszawa',
        about: 'Phasellus venenatis cursus dignissim. Sed elementum mattis enim non posuere. Suspendisse mollis hendrerit massa a iaculis. Sed aliquet auctor feugiat. Nulla hendrerit eu orci sed condimentum. Curabitur at faucibus turpis. Vestibulum ac turpis nec urna venenatis accumsan.',
        status: 'Panna',
        education: 'Zawodowe',
        job: 'Kasjer w biedronka',
        fit1: 57,
        fit2: 89,
        fit3: 76
      },
      {
        id:2,
        name: 'Halyna',
        age: 26,
        region: 'Mazowieckie',
        city: 'Klapków',
        about: 'Quisque sagittis urna in lacinia molestie. Vivamus placerat id lacus eget molestie. Ut id lorem nibh. Vestibulum suscipit justo lectus, id pretium tortor viverra vel. Donec elit enim, viverra et quam in, mattis blandit elit. Vivamus sed lorem lacus. Duis ac posuere tellus. Nulla cursus efficitur arcu, nec tempor turpis venenatis nec.',
        status: 'Wdowa',
        education: 'Wyższe',
        job: 'Sprzątaczka na Okęciu',
        fit1: 87,
        fit2: 69,
        fit3: 56
      },
      {
        id:3,
        name: 'Mariola',
        age: 18,
        region: 'Mazowieckie',
        city: 'Chodaków',
        about: 'Mauris vitae tortor lacinia, elementum augue sit amet, scelerisque nisi. Maecenas semper tristique metus, non ultricies mauris faucibus ut. ',
        status: 'Panna',
        education: 'Gimnazjalne',
        job: 'Szlachta nie pracuje',
        fit1: 52,
        fit2: 79,
        fit3: 65
      },
      {
        id:4,
        name: 'Kazimira',
        age: 28,
        region: 'Mazowieckie',
        city: 'Robaków',
        about: 'Scelerisque nisi. Maecenas semper tristique metus, non ultricies mauris faucibus ut. ',
        status: 'Rozwódka',
        education: 'Podstawowe',
        job: 'Szlachta baluje',
        fit1: 72,
        fit2: 69,
        fit3: 75
      },
      {
        id:5,
        name: 'Ryszarda',
        age: 24,
        region: 'Mazowieckie',
        city: 'Radom',
        about: 'Vivamus luctus a est ultricies cursus. Fusce nec diam id ante egestas maximus eu vel dolor. Duis id dui a nibh varius lacinia vitae cursus turpis. Sed feugiat ligula vel dolor commodo, et volutpat purus egestas.',
        status: 'Zamężna',
        education: 'Zawodowe',
        job: 'Żabka',
        fit1: 62,
        fit2: 81,
        fit3: 77
      }
    ];

    let resp: any = [];
    let page=pageNo-1;

    for(var _i = 1; _i <= size; _i++){
      let per = {
        id: _i + 10*page,
        name: 'Imie'+ (_i + 10*page),
        age: 24+_i,
        region: 'Mazowieckie',
        city: 'Radom',
        about: 'Vivamus luctus a est ultricies cursus. Fusce nec diam id ante egestas maximus eu vel dolor. Duis id dui a nibh varius lacinia vitae cursus turpis. Sed feugiat ligula vel dolor commodo, et volutpat purus egestas.',
        status: 'Panna',
        education: 'Zawodowe',
        job: 'Szlachta nie pracuje',
        fit1: 62,
        fit2: 81,
        fit3: 77
      }
      resp.push(per);
    }
    return resp;
  }
}
