import {
  AfterViewInit, Component, ElementRef, HostListener, Inject, Input, OnInit, QueryList, ViewChild,
  ViewChildren
} from '@angular/core';
import {PrivateMessage} from "../../../_model/private-message";
import {DOCUMENT} from "@angular/common";
import {ChatManagerService} from "../chat-manager.service";

@Component({
  selector: 'app-chat-conversation',
  templateUrl: './chat-conversation.component.html',
  styleUrls: ['./chat-conversation.component.css']
})
export class ChatConversationComponent implements OnInit, AfterViewInit {

  @Input('messagesList') msgList: PrivateMessage[] = [];

  constructor(private chatService: ChatManagerService) { }

  ngOnInit() {
  }

  ngAfterViewInit() {
    this.messages.changes.subscribe(this.scrollToBottom);
  }

  @ViewChildren('messages') messages: QueryList<any>;
  @ViewChild('chatContent') content: ElementRef;


  onScroll(event) {
    if(event.target.scrollTop == 0){
      console.log("TOP!");
      setTimeout(()=>{
        this.handleUpdateBefore(event);
      },2000);
    }
  }

  handleUpdateBefore(event){
    if(event.target.scrollTop == 0){
      this.chatService.updateMessagesBefore();
    }
  }

  scrollToBottom = () => {
    try {
      this.content.nativeElement.scrollTop = this.content.nativeElement.scrollHeight;
    } catch (err) {}
  };

  test(){
    console.log("TEST");
    this.scrollToBottom();
  }

}
