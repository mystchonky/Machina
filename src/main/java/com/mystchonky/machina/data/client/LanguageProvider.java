package com.mystchonky.machina.data.client;

import com.mystchonky.machina.Machina;
import com.mystchonky.machina.common.registrar.ItemRegistrar;
import net.minecraft.data.PackOutput;

public class LanguageProvider extends net.neoforged.neoforge.common.data.LanguageProvider {
    public LanguageProvider(PackOutput output, String locale) {
        super(output, Machina.MODID, locale);
    }

    @Override
    protected void addTranslations() {
        add(ItemRegistrar.EXO_HELMET.get(), "EXO Helmet");
        add(ItemRegistrar.EXO_PLATE.get(), "EXO Plate");
        add(ItemRegistrar.EXO_LEGGINGS.get(), "EXO Leggings");
        add(ItemRegistrar.EXO_BOOTS.get(), "EXO Boots");
    }
}
