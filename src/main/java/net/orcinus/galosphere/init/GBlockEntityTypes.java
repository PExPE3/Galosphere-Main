package net.orcinus.galosphere.init;

import net.minecraft.world.level.block.entity.BlockEntityType;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;
import net.minecraftforge.registries.RegistryObject;
import net.orcinus.galosphere.Galosphere;
import net.orcinus.galosphere.blocks.blockentities.AuraRingerBlockEntity;
import net.orcinus.galosphere.blocks.blockentities.GlowInkClumpsBlockEntity;

@Mod.EventBusSubscriber(modid = Galosphere.MODID, bus = Mod.EventBusSubscriber.Bus.MOD)
public class GBlockEntityTypes {

    public static final DeferredRegister<BlockEntityType<?>> BLOCK_ENTITIES = DeferredRegister.create(ForgeRegistries.BLOCK_ENTITY_TYPES, Galosphere.MODID);

    public static final RegistryObject<BlockEntityType<AuraRingerBlockEntity>> AURA_RINGER = BLOCK_ENTITIES.register("aura_ringer", () -> BlockEntityType.Builder.of(AuraRingerBlockEntity::new, GBlocks.AURA_RINGER.get()).build(null));
    public static final RegistryObject<BlockEntityType<GlowInkClumpsBlockEntity>> GLOW_INK_CLUMPS = BLOCK_ENTITIES.register("glow_ink_clumps", () -> BlockEntityType.Builder.of(GlowInkClumpsBlockEntity::new, GBlocks.GLOW_INK_CLUMPS.get()).build(null));

}



