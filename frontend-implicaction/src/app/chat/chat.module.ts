import {NgModule} from '@angular/core';
import {CommonModule} from '@angular/common';
import {FriendsListComponent} from "./component/friends-list/friends-list.component";
import {ChatComponent} from "./chat.component";

@NgModule({
  declarations: [
    FriendsListComponent,
    ChatComponent
  ],
  imports: [
    CommonModule,
  ]
})
export class ChatModule {
}
