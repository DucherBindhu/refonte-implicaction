import {Component, Input, OnInit} from '@angular/core';
import {Post} from '../../model/post';
import {PostService} from '../../services/post.service';
import {ActivatedRoute} from '@angular/router';
import {ToasterService} from '../../../core/services/toaster.service';
import {finalize} from 'rxjs/operators';

@Component({
  selector: 'app-post-detail',
  templateUrl: './post-detail.component.html',
  styleUrls: ['./post-detail.component.scss']
})
export class PostDetailComponent implements OnInit {
  @Input()
  post: Post = {};

  isLoading = true;

  constructor(
    private postService: PostService,
    private route: ActivatedRoute,
    private toasterService: ToasterService
  ) {
  }

  ngOnInit(): void {
    this.route.paramMap.subscribe(paramMap => {
        const postId = paramMap.get('postId');
        this.postService
          .getById(postId)
          .pipe(finalize(() => this.isLoading = false))
          .subscribe(
            post => this.post = post,
            () => this.toasterService.error('oops', 'Une erreur est survenue !')
          );
      }
    );
  }

}
