package br.com.mushmc.apis;

import java.lang.reflect.Field;
import java.lang.reflect.Modifier;
import java.util.ArrayList;
import java.util.Base64;
import java.util.List;
import java.util.UUID;
 
import org.bukkit.Color;
import org.bukkit.Material;
import org.bukkit.craftbukkit.v1_8_R3.inventory.CraftItemStack;
import org.bukkit.enchantments.Enchantment;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.ItemMeta;
import org.bukkit.inventory.meta.LeatherArmorMeta;
import org.bukkit.inventory.meta.SkullMeta;
 
import com.mojang.authlib.GameProfile;
import com.mojang.authlib.properties.Property;
 
import net.md_5.bungee.api.ChatColor;
 
public class MakeItem {
 
    private ItemStack ik;
 
    public MakeItem(Material material) {
        ik = new ItemStack(material);
    }
    
    public MakeItem(String id) {
    	if (id.contains(":")) {
    	      this.ik = new MakeItem(Integer.parseInt(id.split(":")[0]), (byte)Integer.parseInt(id.split(":")[1])).build();
    	    } else {
    	      this.ik = new MakeItem(Integer.parseInt(id)).build();
    	    }
    }
 
    public MakeItem(Material material, byte data) {
        ik = new ItemStack(material, 1, (short)data);
    }
 
    public MakeItem(String owner, String name) {
        ik = new ItemStack(Material.SKULL_ITEM, 1, (byte) 3);
        SkullMeta skullMeta = (SkullMeta) ik.getItemMeta();
        skullMeta.setDisplayName(name);
        skullMeta.setOwner(owner);
        ik.setItemMeta(skullMeta);
    }
 
    private static Field profileField;
 
    public MakeItem addEnchantment(Enchantment enchant, int level) {
        ik.addUnsafeEnchantment(enchant, level);
        return this;
    }
 
    public static ItemStack getCustomSkullURL(String url) {
        ItemStack item = new ItemStack(Material.SKULL_ITEM, 1, (short) 3);
        SkullMeta meta = (SkullMeta) item.getItemMeta();
 
        GameProfile profile = new GameProfile(UUID.randomUUID(), null);
        byte[] data = Base64.getEncoder().encode(String.format("{textures:{SKIN:{url:\"%s\"}}}", url).getBytes());
        profile.getProperties().put("textures", new Property("textures", new String(data)));
 
        try {
            if (profileField == null) {
                profileField = meta.getClass().getDeclaredField("profile");
            }
 
            profileField.setAccessible(true);
            profileField.set(meta, profile);
 
            item.setItemMeta(meta);
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
        return item;
    }
 
    public static ItemStack getCustomSkullTexture(String texture) {
        ItemStack item = new ItemStack(Material.SKULL_ITEM, 1, (short) 3);
        SkullMeta meta = (SkullMeta) item.getItemMeta();
 
        GameProfile profile = new GameProfile(UUID.randomUUID(), null);
 
        profile.getProperties().put("textures", new Property("textures", new String(texture)));
 
        try {
            if (profileField == null) {
                profileField = meta.getClass().getDeclaredField("profile");
            }
 
            profileField.setAccessible(true);
            profileField.set(meta, profile);
 
            item.setItemMeta(meta);
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
        return item;
    }
 
    @SuppressWarnings("deprecation")
    public MakeItem(int material, byte data) {
        ik = new ItemStack(material, 1, (short)data);
    }
 
    public MakeItem(ItemStack ik) {
        this.ik = ik.clone();
    }
 
    @SuppressWarnings("deprecation")
    public MakeItem(int material) {
        ik = new ItemStack(material);
    }
 
    public MakeItem setAmout(int amount) {
        ik.setAmount(amount);
        return this;
    }
 
    public MakeItem setName(String name) {
        ItemMeta im = ik.getItemMeta();
        im.setDisplayName(name.replace("&", "�"));
        ik.setItemMeta(im);
        return this;
    }
  
    public MakeItem setColor(Color color) {
 
        try {
            LeatherArmorMeta meta = (LeatherArmorMeta) ik.getItemMeta();
            meta.setColor(color);
            ik.setItemMeta(meta);
        } catch (Exception e) {
        }
 
        return this;
    }
 
    public MakeItem setLore(ArrayList<String> lore) {
        ItemMeta im = ik.getItemMeta();
        ArrayList<String> lorer = new ArrayList<>();
        for (String r : lore) {
            lorer.add(r.replace("&", "�"));
        }
        im.setLore(lorer);
        ik.setItemMeta(im);
        return this;
    }
 
    public MakeItem addLore(ArrayList<String> lore, ChatColor color) {
        ItemMeta im = ik.getItemMeta();
        ArrayList<String> lorer = new ArrayList<>();
        for (String r : lore) {
            lorer.add(color + r.replace("&", "�"));
        }
        im.setLore(lorer);
        ik.setItemMeta(im);
        return this;
    }
 
    public MakeItem addLoreList(String... name) {
        for (String s : name) {
            addLore(s);
        }
        return this;
    }
 
    public MakeItem addLore(List<String> lore) {
        ItemMeta im = ik.getItemMeta();
        ArrayList<String> lorer = new ArrayList<>();
        for (String r : lore) {
            lorer.add(r.replace("&", "�"));
        }
        im.setLore(lorer);
        ik.setItemMeta(im);
        return this;
    }
 
    public MakeItem addLore(String lore) {
        ItemMeta im = ik.getItemMeta();
        List<String> lorer = new ArrayList<>();
        if (im.hasLore()) {
            lorer = im.getLore();
        }
        if (lore.contains("/n")) {
            for (String x : lore.split("/n")) {
                lorer.add(x.replace("&", "�"));
            }
        } else {
            lorer.add(lore.replace("&", "�"));
        }
        im.setLore(lorer);
        ik.setItemMeta(im);
        return this;
    }
 
    public MakeItem remLore(int amount) {
        ItemMeta im = ik.getItemMeta();
        List<String> lorer = new ArrayList<>();
        if (im.hasLore()) {
            lorer = im.getLore();
        }
        for (int i = 0; i < amount; i++) {
            if (!lorer.isEmpty()) {
                lorer.remove(lorer.size() - 1);
            }
        }
        im.setLore(lorer);
        ik.setItemMeta(im);
        return this;
    }
 
    public MakeItem addLore(String[] lore) {
        ItemMeta im = ik.getItemMeta();
        List<String> lorer = new ArrayList<>();
        if (im.hasLore()) {
            lorer = im.getLore();
        }
        for (String x : lore) {
            lorer.add(x.replace("&", "�"));
        }
        im.setLore(lorer);
        ik.setItemMeta(im);
        return this;
    }
 
    public ItemStack build() {
        return ik;
    }
 
    public static boolean checkIsSimilar(ItemStack ik1, ItemStack ik2) {
        if (ik1 == null)
            return false;
        if (ik2 == null)
            return false;
        if (ik1.getType() == ik2.getType()) {
            if (ik1.hasItemMeta() && ik2.hasItemMeta()) {
                if (ik1.getItemMeta().hasDisplayName() && ik2.getItemMeta().hasDisplayName()) {
                    if (ik1.getItemMeta().getDisplayName().equals(ik2.getItemMeta().getDisplayName())) {
                        if (ik1.getItemMeta().hasLore() && ik2.getItemMeta().hasLore()) {
                            if (ik1.getItemMeta().getLore().equals(ik2.getItemMeta().getLore())) {
                                return true;
                            } else {
                                return false;
                            }
                        } else {
                            return false;
                        }
                    } else {
                        return false;
                    }
                } else {
                    return false;
                }
            } else {
                return false;
            }
        } else {
            return false;
        }
    }
 
    public static boolean checkIsSimilar(ItemStack ik1, ItemStack ik2, boolean use_lore) {
        if (ik1 == null)
            return false;
        if (ik2 == null)
            return false;
        if (ik1.getType() == ik2.getType()) {
            if (ik1.hasItemMeta() && ik2.hasItemMeta()) {
                if (ik1.getItemMeta().hasDisplayName() && ik2.getItemMeta().hasDisplayName()) {
                    if (ik1.getItemMeta().getDisplayName().equals(ik2.getItemMeta().getDisplayName())) {
                        if (use_lore) {
                            if (ik1.getItemMeta().hasLore() && ik2.getItemMeta().hasLore()) {
                                if (ik1.getItemMeta().getLore().equals(ik2.getItemMeta().getLore())) {
                                    return true;
                                } else {
                                    return false;
                                }
                            } else {
                                return false;
                            }
                        } else {
                            return true;
                        }
                    } else {
                        return false;
                    }
                } else {
                    return false;
                }
            } else {
                return false;
            }
        } else {
            return false;
        }
    }
 
    public MakeItem setMaxStackSize(int amount) {
        net.minecraft.server.v1_8_R3.ItemStack nmsItem = CraftItemStack.asNMSCopy(ik);
        Field field = null;
        Field modifier = null;
 
        try {
            field = net.minecraft.server.v1_8_R3.Item.class.getDeclaredField("maxStackSize");
            modifier = Field.class.getDeclaredField("modifiers");
        } catch (Exception ex) {
            ex.printStackTrace();
        }
 
        field.setAccessible(true);
        modifier.setAccessible(true);
 
        try {
            modifier.setInt(field, field.getModifiers() & ~Modifier.PROTECTED);
            field.set(nmsItem.getItem(), amount);
        } catch (Exception ex) {
            ex.printStackTrace();
        }
 
        ik = CraftItemStack.asBukkitCopy(nmsItem);
        return this;
    }
 
    public int getMaxStackSize() {
        net.minecraft.server.v1_8_R3.ItemStack nmsItem = CraftItemStack.asNMSCopy(ik);
        Field field = null;
        Field modifier = null;
 
        try {
            field = net.minecraft.server.v1_8_R3.Item.class.getDeclaredField("maxStackSize");
            modifier = Field.class.getDeclaredField("modifiers");
        } catch (Exception ex) {
            ex.printStackTrace();
        }
 
        field.setAccessible(true);
        modifier.setAccessible(true);
 
        try {
            modifier.setInt(field, field.getModifiers() & ~Modifier.PROTECTED);
            return (int) field.get(nmsItem.getItem());
        } catch (Exception ex) {
            ex.printStackTrace();
        }
        return 0;
    }
 
    public static ItemStack setMaxStackSize(ItemStack is, int amount) {
        net.minecraft.server.v1_8_R3.ItemStack nmsItem = CraftItemStack.asNMSCopy(is);
        Field field = null;
        Field modifier = null;
 
        try {
            field = net.minecraft.server.v1_8_R3.Item.class.getDeclaredField("maxStackSize");
            modifier = Field.class.getDeclaredField("modifiers");
        } catch (Exception ex) {
            ex.printStackTrace();
        }
 
        field.setAccessible(true);
        modifier.setAccessible(true);
 
        try {
            modifier.setInt(field, field.getModifiers() & ~Modifier.PROTECTED);
            field.set(nmsItem.getItem(), amount);
        } catch (Exception ex) {
            ex.printStackTrace();
        }
 
        return CraftItemStack.asBukkitCopy(nmsItem);
    }
 
    public MakeItem setLore(List<String> lore) {
        ItemMeta im = ik.getItemMeta();
        ArrayList<String> lorer = new ArrayList<>();
        for (String r : lore) {
            lorer.add(r.replace("&", "�"));
        }
        im.setLore(lorer);
        ik.setItemMeta(im);
        return this;
    } 
}