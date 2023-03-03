import { Injectable } from '@angular/core';
import {
  AngularFireDatabase,
  AngularFireList,
} from '@angular/fire/compat/database';
import {
  getDownloadURL,
  getStorage,
  ref,
  StorageReference,
} from 'firebase/storage';
@Injectable({
  providedIn: 'root',
})
export class ImageService {
  storage = getStorage();

  pathReference: StorageReference | undefined;
  constructor(private firebase: AngularFireDatabase) {}

  async getImage(pathName: any) {
    try {
      return await getDownloadURL(ref(this.storage, pathName));
    } catch (error) {
      return await getDownloadURL(ref(this.storage, "/error/none.jpg"));
    }

  }
}
