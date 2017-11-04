import {AfterViewInit, Component, ElementRef, OnInit, QueryList, ViewChild, ViewChildren} from '@angular/core';

@Component({
  selector: 'app-chat-conversation',
  templateUrl: './chat-conversation.component.html',
  styleUrls: ['./chat-conversation.component.css']
})
export class ChatConversationComponent implements OnInit, AfterViewInit {

  public msgSource: any[] = [];

  constructor() { }

  ngOnInit() {
  }

  ngAfterViewInit() {
    this.messages.changes.subscribe(this.scrollToBottom);
  }

  @ViewChildren('messages') messages: QueryList<any>;
  @ViewChild('chatContent') content: ElementRef;

  scrollToBottom = () => {
    try {
      this.content.nativeElement.scrollTop = this.content.nativeElement.scrollHeight;
    } catch (err) {}
  };

  test(){
    console.log("TEST");
    this.scrollToBottom();
  }


  test2(){
    console.log("TEST");
    this.addMock();
  }

  addMock(){
    let mockMsg = {
      text: 'Lorem ipsum dolor sit amet, consectetur adipiscing elit. Aliquam mauris risus, iaculis eget purus congue, fermentum tristique lacus. Praesent non sapien dapibus, posuere purus ut, elementum nibh.',
      date: new Date(),
    };
    this.msgSource.push(mockMsg);
  }

}
