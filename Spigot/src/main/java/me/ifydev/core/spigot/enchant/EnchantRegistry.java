package me.ifydev.core.spigot.enchant;

import lombok.Getter;
import org.bukkit.enchantments.Enchantment;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

/**
 * @author Innectic
 * @since 10/5/2017
 */
public class EnchantRegistry {

    @Getter private static List<BaseEnchant> enchants = new ArrayList<>();

    private static boolean setup = false;

    public static void setup() {
        if (setup) return;
        setup = true;

        enchants.add(new BaseEnchant("Aqua Affinity", Enchantment.AQUA_AFFINITY));
        enchants.add(new BaseEnchant("Bane of Athropods", Enchantment.BANE_OF_ARTHROPODS));
        enchants.add(new BaseEnchant("Blast Protection", Enchantment.BLAST_PROTECTION));
        enchants.add(new BaseEnchant("Curse of Binding", Enchantment.BINDING_CURSE));
        enchants.add(new BaseEnchant("Curse of Vanishing", Enchantment.VANISHING_CURSE));
        enchants.add(new BaseEnchant("Depth Strider", Enchantment.DEPTH_STRIDER));
        enchants.add(new BaseEnchant("Efficiency", Enchantment.EFFICIENCY));
        enchants.add(new BaseEnchant("Feather Falling", Enchantment.FEATHER_FALLING));
        enchants.add(new BaseEnchant("Fire Aspect", Enchantment.FIRE_ASPECT));
        enchants.add(new BaseEnchant("Fire Protection", Enchantment.FIRE_PROTECTION));
        enchants.add(new BaseEnchant("Flame", Enchantment.FLAME));
        enchants.add(new BaseEnchant("Loyalty", Enchantment.LOYALTY));
        enchants.add(new BaseEnchant("Fortune", Enchantment.FORTUNE));
        enchants.add(new BaseEnchant("Frost Walker", Enchantment.FROST_WALKER));
        enchants.add(new BaseEnchant("Infinity", Enchantment.INFINITY));
        enchants.add(new BaseEnchant("Knockback", Enchantment.KNOCKBACK));
        enchants.add(new BaseEnchant("Looting", Enchantment.LOOTING));
        enchants.add(new BaseEnchant("Luck of the Sea", Enchantment.LUCK_OF_THE_SEA));
        enchants.add(new BaseEnchant("Lure", Enchantment.LURE));
        enchants.add(new BaseEnchant("Mending", Enchantment.MENDING));
        enchants.add(new BaseEnchant("Power", Enchantment.POWER));
        enchants.add(new BaseEnchant("Projectile Protection", Enchantment.PROJECTILE_PROTECTION));
        enchants.add(new BaseEnchant("Protection", Enchantment.PROTECTION));
        enchants.add(new BaseEnchant("Punch", Enchantment.PUNCH));
        enchants.add(new BaseEnchant("Respiration", Enchantment.RESPIRATION));
        enchants.add(new BaseEnchant("Sharpness", Enchantment.SHARPNESS));
        enchants.add(new BaseEnchant("Silk Touch", Enchantment.SILK_TOUCH));
        enchants.add(new BaseEnchant("Smite", Enchantment.SMITE));
        enchants.add(new BaseEnchant("Sweeping Edge", Enchantment.SWEEPING_EDGE));
        enchants.add(new BaseEnchant("Thorns", Enchantment.THORNS));
        enchants.add(new BaseEnchant("Unbreaking", Enchantment.UNBREAKING));
        // New enchants
        enchants.add(new BaseEnchant("Soul Speed", Enchantment.SOUL_SPEED));
        enchants.add(new BaseEnchant("Swift Sneak", Enchantment.SWIFT_SNEAK));
        // 1.12 enchants
        enchants.add(new BaseEnchant("Density", Enchantment.DENSITY));
        enchants.add(new BaseEnchant("Breach", Enchantment.BREACH));
        enchants.add(new BaseEnchant("Wind Burst", Enchantment.WIND_BURST));
    }

    public static Optional<BaseEnchant> find(String name) {
        List<BaseEnchant> items = enchants.stream().filter(item -> item.getName()
                .equalsIgnoreCase(name)).collect(Collectors.toList());
        if (items.size() > 1) {
            System.out.println("Somehow got multiple enchants from search result? " + name);
            return Optional.empty();
        }
        return items.size() == 1 ? Optional.of(items.get(0)) : Optional.empty();
    }

}
