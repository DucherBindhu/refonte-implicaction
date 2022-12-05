import {Component, Input, TemplateRef} from '@angular/core';
import {Constants} from "../config/constants";
import {Univers} from "../shared/enums/univers";
import {User} from "../shared/models/user";

@Component({
  selector: 'app-chat-page',
  templateUrl: './chat-page.component.html',
  styleUrls: ['./chat-page.component.scss']
})
export class ChatPageComponent {

  readonly constant = Constants;
  readonly univer = Univers;

  @Input()
  user: User;

  @Input()
  innerTemplate: TemplateRef<any>;


}
