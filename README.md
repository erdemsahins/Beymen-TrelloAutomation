## Beymen Selenium & Trello Rest-Asured Test Case

Maven projesi olarak birlikte yazılmıştır. 
Selenium, JUnit, Log4J, Rest-Asured ve TestNG  kütüphanelerini kullanılmıştır.

### Selenium Web Otomasyon
- www.beymen.com sitesi açılır.
- Ana sayfanın açıldığı kontrol edilir.
- Arama kutucuğuna “şort” kelimesi girilir.(Not = Şort kelimesi excel dosyası
üzerinden 1 sütun 1 satırdan alınarak yazılmalıdır. )
- Arama kutucuğuna girilen “şort” kelimesi silinir.
- Arama kutucuğuna “gömlek” kelimesi girilir.(Not = Gömlek kelimesi excel dosyası
üzerinden 2 sütun 1 satırdan alınarak yazılmalıdır. )
- Klavye üzerinden “enter” tuşuna bastırılır
- Sonuca göre sergilenen ürünlerden rastgele bir ürün seçilir.
- Seçilen ürünün ürün bilgisi ve tutar bilgisi txt dosyasına yazılır.
- Seçilen ürün sepete eklenir.
- Ürün sayfasındaki fiyat ile sepette yer alan ürün fiyatının doğruluğu karşılaştırılır.
- Adet arttırılarak ürün adedinin 2 olduğu doğrulanır.
- Ürün sepetten silinerek sepetin boş olduğu kontrol edilir.


### Trello Rest-Asured Test Case

- Trello üzerinde bir board oluşturunuz.
- Oluşturduğunuz board’ a iki tane kart oluşturunuz.
- Oluştrduğunuz bu iki karttan random olacak sekilde bir tanesini güncelleyiniz.
- Oluşturduğunuz kartları siliniz.
- Oluşturduğunuz board’ u siliniz.
