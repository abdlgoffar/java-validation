package javaValidation.groups;

import jakarta.validation.GroupSequence;
import jakarta.validation.groups.Default;

//disini contoh pengurutan group yg mana akan divalidasi terlebih dahulu, jika disuatu group terdapat validasi yg error
//maka proses validasi di urutan group selanjutnya tidak akan dilakukan
@GroupSequence(value = {Default.class, CreditCardPayGroup.class, VirtualAccountPayGroup.class})
public interface PayGroup2 {
}
