package net.orcinus.galosphere.datagen;

import net.minecraft.core.Direction;
import net.minecraft.data.DataGenerator;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.level.block.AmethystClusterBlock;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.SlabBlock;
import net.minecraft.world.level.block.StairBlock;
import net.minecraft.world.level.block.state.properties.BlockStateProperties;
import net.minecraftforge.client.model.generators.BlockModelBuilder;
import net.minecraftforge.client.model.generators.BlockStateProvider;
import net.minecraftforge.client.model.generators.ConfiguredModel;
import net.minecraftforge.common.data.ExistingFileHelper;
import net.minecraftforge.registries.ForgeRegistries;
import net.minecraftforge.registries.RegistryObject;
import net.orcinus.galosphere.Galosphere;
import net.orcinus.galosphere.blocks.CordycepsBlock;
import net.orcinus.galosphere.blocks.PollinatedClusterBlock;
import net.orcinus.galosphere.init.GBlocks;
import org.jetbrains.annotations.NotNull;

import java.util.Objects;

public class GBlockstateProvider extends BlockStateProvider {

    public GBlockstateProvider(DataGenerator gen, ExistingFileHelper exFileHelper) {
        super(gen, Galosphere.MODID, exFileHelper);
    }

    @Override
    protected void registerStatesAndModels() {
        this.simpleBlock(GBlocks.ALLURITE_BLOCK.get());
        this.simpleBlock(GBlocks.LUMIERE_BLOCK.get());
        this.simpleBlock(GBlocks.SMOOTH_AMETHYST.get());
        this.simpleBlock(GBlocks.SMOOTH_ALLURITE.get());
        this.simpleBlock(GBlocks.SMOOTH_LUMIERE.get());
        this.simpleBlock(GBlocks.AMETHYST_BRICKS.get());
        this.simpleBlock(GBlocks.ALLURITE_BRICKS.get());
        this.simpleBlock(GBlocks.LUMIERE_BRICKS.get());
        this.simpleBlock(GBlocks.CHISELED_AMETHYST.get());
        this.simpleBlock(GBlocks.CHISELED_ALLURITE.get());
        this.simpleBlock(GBlocks.CHISELED_LUMIERE.get());
        this.simpleBlock(GBlocks.AMETHYST_LAMP.get());
        this.simpleBlock(GBlocks.ALLURITE_LAMP.get());
        this.simpleBlock(GBlocks.LUMIERE_LAMP.get());
        this.simpleBlock(GBlocks.RAW_SILVER_BLOCK.get());
        this.simpleBlock(GBlocks.SILVER_BLOCK.get());
        this.simpleBlock(GBlocks.SILVER_ORE.get());
        this.simpleBlock(GBlocks.DEEPSLATE_SILVER_ORE.get());
        this.simpleBlock(GBlocks.CHARGED_LUMIERE_BLOCK.get());
        this.simpleBlock(GBlocks.LICHEN_MOSS.get());

        this.crossBlock(GBlocks.LICHEN_ROOTS);
        this.crossBlock(GBlocks.BOWL_LICHEN);
        this.getVariantBuilder(GBlocks.LICHEN_CORDYCEPS.get()).forAllStatesExcept(state -> {
            boolean bulb = state.getValue(CordycepsBlock.BULB);
            BlockModelBuilder crossFile = models().cross("lichen_cordyceps", new ResourceLocation(Galosphere.MODID, "block/lichen_cordyceps")).renderType("cutout");
            BlockModelBuilder bulbcrossFile = models().cross("lichen_cordyceps_bulb", new ResourceLocation(Galosphere.MODID, "block/lichen_cordyceps_bulb")).renderType("cutout");
            return ConfiguredModel.builder().modelFile(bulb ? bulbcrossFile : crossFile).build();
        }, CordycepsBlock.AGE);
        this.crossBlock(GBlocks.LICHEN_CORDYCEPS_PLANT);

        this.slabBlock(GBlocks.AMETHYST_SLAB.get(), "amethyst_block", true);
        this.slabBlock(GBlocks.ALLURITE_SLAB.get(), "allurite_block");
        this.slabBlock(GBlocks.LUMIERE_SLAB.get(), "lumiere_block");
        this.slabBlock(GBlocks.SMOOTH_AMETHYST_SLAB.get(), "smooth_amethyst");
        this.slabBlock(GBlocks.SMOOTH_ALLURITE_SLAB.get(), "smooth_allurite");
        this.slabBlock(GBlocks.SMOOTH_LUMIERE_SLAB.get(), "smooth_lumiere");
        this.slabBlock(GBlocks.AMETHYST_BRICK_SLAB.get(), "amethyst_bricks");
        this.slabBlock(GBlocks.ALLURITE_BRICK_SLAB.get(), "allurite_bricks");
        this.slabBlock(GBlocks.LUMIERE_BRICK_SLAB.get(), "lumiere_bricks");

        this.stairsBlock(GBlocks.AMETHYST_STAIRS.get(), "amethyst_block", true);
        this.stairsBlock(GBlocks.ALLURITE_STAIRS.get(), "allurite_block");
        this.stairsBlock(GBlocks.LUMIERE_STAIRS.get(), "lumiere_block");
        this.stairsBlock(GBlocks.SMOOTH_AMETHYST_STAIRS.get(), "smooth_amethyst");
        this.stairsBlock(GBlocks.SMOOTH_ALLURITE_STAIRS.get(), "smooth_allurite");
        this.stairsBlock(GBlocks.SMOOTH_LUMIERE_STAIRS.get(), "smooth_lumiere");
        this.stairsBlock(GBlocks.AMETHYST_BRICK_STAIRS.get(), "amethyst_bricks");
        this.stairsBlock(GBlocks.ALLURITE_BRICK_STAIRS.get(), "allurite_bricks");
        this.stairsBlock(GBlocks.LUMIERE_BRICK_STAIRS.get(), "lumiere_bricks");

        this.getVariantBuilder(GBlocks.COMBUSTION_TABLE.get()).forAllStates(state -> ConfiguredModel.builder().modelFile(models().cubeBottomTop("combustion_table", new ResourceLocation(Galosphere.MODID, "block/combustion_table_side"), new ResourceLocation(Galosphere.MODID, "block/combustion_table_bottom"), new ResourceLocation(Galosphere.MODID, "block/combustion_table_top"))).build());

        this.pollinatedCluster(GBlocks.ALLURITE_CLUSTER.get());
        this.pollinatedCluster(GBlocks.LUMIERE_CLUSTER.get());

    }

    private void pollinatedCluster(@NotNull Block block) {
        this.getVariantBuilder(block).forAllStatesExcept(state -> {
            Direction facing = state.getValue(AmethystClusterBlock.FACING);
            int rotationX = 90;
            int rotationY = 90;
            if (facing == Direction.UP) {
                rotationX = 0;
                rotationY = 0;
            } else if (facing == Direction.DOWN) {
                rotationX = 180;
                rotationY = 0;
            } else if (facing == Direction.WEST) {
                rotationY *= 3;
            } else if (facing == Direction.NORTH) {
                rotationY = 0;
            } else if (facing == Direction.SOUTH) {
                rotationY *= 2;
            }
            return ConfiguredModel.builder()
                    .modelFile(models().cross(ForgeRegistries.BLOCKS.getKey(block).getPath(), new ResourceLocation(Galosphere.MODID, "block/" + ForgeRegistries.BLOCKS.getKey(block).getPath())).renderType("cutout"))
                    .rotationX(rotationX)
                    .rotationY(rotationY)
                    .build();
        }, BlockStateProperties.WATERLOGGED, PollinatedClusterBlock.POLLINATED);
    }

    private void crossBlock(RegistryObject<Block> block) {
        this.getVariantBuilder(block.get())
                .forAllStates(state -> ConfiguredModel.builder()
                        .modelFile(models().cross(Objects.requireNonNull(ForgeRegistries.BLOCKS.getKey(block.get())).getPath(), new ResourceLocation(Galosphere.MODID, "block/" + ForgeRegistries.BLOCKS.getKey(block.get()).getPath())).renderType("cutout")).build());
    }

    private void stairsBlock(Block block, String blockMaterial) {
        this.stairsBlock(block, blockMaterial, false);
    }

    private void stairsBlock(Block block, String blockMaterial, boolean flag) {
        String id = flag ? "minecraft" : Galosphere.MODID;
        ResourceLocation resourceLocation = new ResourceLocation(id, "block/" + blockMaterial);
        this.stairsBlock((StairBlock) block, resourceLocation);
    }

    private void slabBlock(Block block, String blockMaterial) {
        this.slabBlock(block, blockMaterial, false);
    }

    private void slabBlock(Block block, String blockMaterial, boolean flag) {
        String id = flag ? "minecraft" : Galosphere.MODID;
        ResourceLocation resourceLocation = new ResourceLocation(id, "block/" + blockMaterial);
        this.slabBlock((SlabBlock) block, resourceLocation, resourceLocation);
    }

}
