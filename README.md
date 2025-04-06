Kullanıcı girdisi ve film girdisi alan ve bunları dizilerde saklayıp
daha sonrasında kullanıcıya gösterebilen bir program yazdım.

Öncelikle film ve müşteri bilgilerini tutacak dizilerimi oluşturdum.
Ardından kullanıcıyla etkileşimli bir menü oluşturdum, bu menüde
switch-case yapısıyla hangi işlemi yapmak istiyorsa onu seçip işlem yapılabiliyor.

Film ekleme, müşteri ekleme ve bilet kaydı gibi işlemler ayrı ayrı
fonksiyonlar şeklinde yazıldı. Kullanıcıdan alınan veriler scanner ile alınıyor
ve bu veriler uygun dizilere kaydediliyor.

Bilet oluştururken kullanıcıya hangi müşteri hangi filme bilet almış
onu seçtiriyoruz ve bu bilgiler 2 boyutlu dizide saklanıyor.

Scanner kapatma işlemini her fonksiyonda yapmak yerine switch-case’in
en sonunda bir kere kapatmayı daha mantıklı buldum.

Ayrıca, nextLine() fonksiyonunu kullanarak kullanıcıdan boşluklu veri
alabilme imkanı sağladım. Böylece isim veya film adı girerken boşluk sorun olmuyor.

Son olarak biletleri listelerken bir for döngüsüyle dizileri gezerek
bilet bilgilerini sırayla ekrana yazdırıyoruz.