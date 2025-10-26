import java.time.LocalDate;
import java.time.format.TextStyle;
import java.time.temporal.ChronoUnit;
import java.util.Date;
import java.util.Locale;

public class LogikaPerhitunganHari {
     public String[] getNamaBulan() {
        String[] bulan = new String[12];
        for (int i = 0; i < 12; i++) {
            bulan[i] = LocalDate.of(2000, i + 1, 1)
                                .getMonth()
                                .getDisplayName(TextStyle.FULL, new Locale("id"));
        }
        return bulan;
    }

    public String hitungJumlahHari(int bulan, int tahun) {
        LocalDate tanggalAwal = LocalDate.of(tahun, bulan, 1);
        int jumlahHari = tanggalAwal.lengthOfMonth();
        String namaBulan = tanggalAwal.getMonth().getDisplayName(TextStyle.FULL, new Locale("id"));
        return "Jumlah Hari pada " + namaBulan + " " + tahun + " : " + jumlahHari + " hari";
    }

    public String getHariPertama(int bulan, int tahun) {
        LocalDate tanggalAwal = LocalDate.of(tahun, bulan, 1);
        String hari = tanggalAwal.getDayOfWeek().getDisplayName(TextStyle.FULL, new Locale("id"));
        return "Hari Pertama: " + hari;
    }

    public String getHariTerakhir(int bulan, int tahun) {
        LocalDate tanggalAkhir = LocalDate.of(tahun, bulan, 1)
                                          .withDayOfMonth(LocalDate.of(tahun, bulan, 1).lengthOfMonth());
        String hari = tanggalAkhir.getDayOfWeek().getDisplayName(TextStyle.FULL, new Locale("id"));
        return "Hari Terakhir: " + hari;
    }

    public String hitungSelisih(Date d1, Date d2) {
        LocalDate ld1 = new java.sql.Date(d1.getTime()).toLocalDate();
        LocalDate ld2 = new java.sql.Date(d2.getTime()).toLocalDate();
        long selisih = ChronoUnit.DAYS.between(ld1, ld2);
        return "Selisih Hari: " + Math.abs(selisih) + " hari";
    }
    
}
