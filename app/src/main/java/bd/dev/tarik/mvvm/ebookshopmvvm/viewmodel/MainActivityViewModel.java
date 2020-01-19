package bd.dev.tarik.mvvm.ebookshopmvvm.viewmodel;

import android.app.Application;

import androidx.annotation.NonNull;
import androidx.lifecycle.AndroidViewModel;
import androidx.lifecycle.LiveData;

import java.util.List;

import bd.dev.tarik.mvvm.ebookshopmvvm.model.Book;
import bd.dev.tarik.mvvm.ebookshopmvvm.model.Category;
import bd.dev.tarik.mvvm.ebookshopmvvm.model.EBookShopRepository;

public class MainActivityViewModel extends AndroidViewModel {

     private EBookShopRepository eBookShopRepository;
     private LiveData<List<Category>> allCategories;
     private LiveData<List<Book>> booksOfASelectedCategory;

    public MainActivityViewModel(@NonNull Application application) {
        super(application);

        eBookShopRepository = new EBookShopRepository(application);

    }

    public LiveData<List<Category>> getAllCategories() {
        allCategories = eBookShopRepository.getCategories();
        return allCategories;
    }

    public LiveData<List<Book>> getBooksOfASelectedCategory(int categoryId) {
        booksOfASelectedCategory = eBookShopRepository.getBooks(categoryId);
        return booksOfASelectedCategory;
    }

    public void addNewBook(Book book) {
        eBookShopRepository.insertBook(book);
    }
    public void UpdateBook(Book book) {
        eBookShopRepository.updateBook(book);
    }
    public void DeleteBook(Book book) {
        eBookShopRepository.deleteBook(book);
    }
}
